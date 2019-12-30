package root.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.MouseInputListener;
import root.GameMode.Levels.Level;
import root.GameMode.Visuals.NoScalingMode;
import root.GameMode.Visuals.VisualMode;
import root.entities.movable.HeadlessSun;
import root.entities.movable.KillSun;
import root.entities.movable.LuckyBalloon;
import root.entities.movable.MovableObjects;
import root.entities.movable.Pea;
import root.entities.movable.Sun;
import root.entities.plants.Lawnmower;
import root.entities.plants.Plant;
import root.entities.zombies.Zombie;
import root.etc.CellsManager;
import root.etc.ResourcesPath;

public class GamePanel extends JPanel implements Runnable, MouseInputListener, CellsManager, ResourcesPath {

  /* ----------VARS---------- */
  final int DELAY = 50;
  public boolean testMode = false;
  int mouseX, mouseY;
  int LoopCounter = 0;
  public JLabel message = new JLabel();
  public VisualMode visualMode = new NoScalingMode();
  public Level level;
  int levelNumber;
  int popup_loop_counter;
  RESULT gameResult;

  /* ----------INIT---------- */
  public GamePanel() {
    visualMode.initFont();
    addMouseListener(this);
    addMouseMotionListener(this);
    setLayout(null);
    setPreferredSize(visualMode.GameDim);
    resetToLevel(2);
  }

  void initMessage() {
    add(message);
    message.setFont(visualMode.PvZUI_FONT);
    message.setBounds(new Rectangle(new Point(0, 0), visualMode.GameDim));
    message.setHorizontalAlignment(SwingConstants.CENTER);
    message.setForeground(Color.BLACK);
    message.addMouseListener(this);
    level.cards.forEach(message::add);
  }

  /* ----------UTILITIES FUNCTIONS---------- */
  private void resetToLevel(int levelNumber) {
    this.levelNumber = levelNumber;
    LoopCounter = 0;
    popup_loop_counter = 500;
    level = Level.getRound(this.levelNumber, this);
    message.removeAll();
    message.setText("");
    initMessage();
    add(Zombie.initStatus());
    add(Sun.initCountLabel());
    Sun.Count = 0;
    Sun.updateCount(1000 * levelNumber);
    cellMaps.forEach(cellMaps::remove);
  }

  @Override
  public void addNotify() {
    super.addNotify();
    Thread animator = new Thread(this);
    animator.start();
  }

  /* ---------- LOOP ---------- */
  private void cycle() {
    /* ----- Make certain things do their step ----- */
    level.movableEntities.forEach(MovableObjects::actions);
    level.zombies.forEach(Zombie::actions);
    Zombie.updateStatus();
    level.lawnmowers.forEach(Lawnmower::actions);

    /* ----- Setting for the cells ----- */
    cellMaps.forEach((Point, value) -> {
      value.actions();
      value.Stuffs.forEach(MovableObjects::actions);
      value.Stuffs.removeIf(
          stuff -> ((stuff instanceof Sun && (stuff.LoopCounter >= Sun.existLoop || ((Sun) stuff).doneCollected))
              || (stuff instanceof Pea && ((((Pea) stuff).hitted) || ((Pea) stuff).outOfGame))));
    });

    /* ****Zombie Die effects**** */
    level.zombies.forEach(zombie -> {
      if (zombie.health <= 0) {
        level.zombieKilled++;
        level.zombieKilledPosition.put(zombie.getPosition(), 0);
      }
    });


    /* ---- Check for removals ---- */
    level.zombieKilledPosition.keySet().removeIf(tmp -> level.zombieKilledPosition.get(tmp) >= visualMode.ZombieDie.length - 1);
    level.zombies.removeIf(zombie -> zombie.health <= 0 || zombie.getX() + zombie.getImage().getWidth(null) <= 0);

    level.movableEntities
        .removeIf(obj -> (
            (obj instanceof Sun && (obj.LoopCounter >= Sun.existLoop || ((Sun) obj).doneCollected))
                || (obj instanceof LuckyBalloon && (obj.LoopCounter >= LuckyBalloon.existLoop || ((LuckyBalloon) obj).clicked))));

    CellsManager.cellMaps.values().removeIf(plant -> plant.health <= 0);
    level.lawnmowers.removeIf(lawnmower -> lawnmower.getX() > visualMode.GameDim.width);

    /* ----- Tasks that need timer ----- */
    LoopCounter++;
    if (LoopCounter == 25) {
      message.setText("ROUND " + levelNumber);
    } else if (LoopCounter == 50) {
      message.setText("Collect suns to buy plants.");
    } else if (LoopCounter == 75) {
      message.setText("Plants can defend your house.");
    } else if (LoopCounter == 100) {
      message.setText("");
    } else if (LoopCounter == 450) {
      message.setText("Watch out! Zombies are coming");
    } else if (LoopCounter == 500) {
      message.setText("Good luck ^-^");
    } else if (LoopCounter == 2048) {
      popup_loop_counter = LoopCounter;
      message.setText("A big wave of zombies is coming!");
    } else if (LoopCounter > popup_loop_counter + 25 && !message.getText().equals("")) {
      message.setText("");
    }

    if (LoopCounter % 512 == 0) {
      int killSunEdge = visualMode.KillSunImage.getWidth(null);
      level.movableEntities.add(new KillSun((new Random().nextInt(visualMode.GameDim.width - killSunEdge)), 0));
    } else if (LoopCounter % 256 == 0) {
      int luckyEdgeX = visualMode.LuckyBalloonImage.getWidth(null);
      int luckyEdgeY = visualMode.LuckyBalloonImage.getHeight(null);
      level.movableEntities.add(new LuckyBalloon(
          (new Random().nextInt(visualMode.GameDim.width - luckyEdgeX)),
          (new Random().nextInt(visualMode.GameDim.height - luckyEdgeY))
      ));
    } else if (LoopCounter % 128 == 0) {
      int sunEdge = visualMode.SunImage.getWidth(null);
      level.movableEntities.add(
          new HeadlessSun((new Random().nextInt(visualMode.GameDim.width - sunEdge)), 0));
    }

    if (!level.end()) {
      if (LoopCounter > 512 && LoopCounter % 128 == 0) {
        level.addZombie(visualMode);
      } else if (LoopCounter > 1024 && LoopCounter % 64 == 0) {
        level.addZombie(visualMode);
      } else if (LoopCounter > 2048 && LoopCounter % 32 == 0) {
        level.addZombie(visualMode);
      }
    } else {
      if (level.zombies.isEmpty()) {
        message.setText("Well done! You passed round " + levelNumber);
        Level new_level = Level.getRound(++levelNumber, this);
        if (new_level != null) {
          resetToLevel(levelNumber);
        } else {
          /* ---- YOU WIN ---- */
          message.setFont(visualMode.PvZUI_FONT.deriveFont(100f));
          message.setText("CONGRATULATION");
          gameResult = RESULT.WIN;
        }
      }
    }

    level.zombies.forEach(zombie -> {
      if (zombie.getX() <= 0) {
        message.setFont(visualMode.PvZUI_FONT.deriveFont(100f));
        message.setText("GAME OVER");
        gameResult = RESULT.LOSE;
      }
    });
  }

  @Override
  public void run() {
    long beforeTime, timeDiff, sleep;

    beforeTime = System.currentTimeMillis();

    while (true) {
      if (!(message.getText().equals("GAME OVER") || message.getText().equals("CONGRATULATION"))) {
        cycle();
        repaint();
      }
      timeDiff = System.currentTimeMillis() - beforeTime;
      sleep = DELAY - timeDiff;

      if (sleep < 0) {
        sleep = 2;
      }

      try {
        Thread.sleep(sleep);
      } catch (InterruptedException e) {

        String msg = String.format("Thread interrupted: %s", e.getMessage());

        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
      }

      beforeTime = System.currentTimeMillis();
    }
  }

  /* ----------DRAWING---------- */
  @Override
  public void paintComponent(Graphics g) {
    g.drawImage(visualMode.BackgroundImage, 0, 0, this);

    level.lawnmowers.forEach(lawnmower -> {
      g.drawImage(lawnmower.getImage(), lawnmower.getX(), lawnmower.getY() + 20, null);
      if (testMode) {
        g.drawRect(lawnmower.getBounds().x, lawnmower.getBounds().y + 20, lawnmower.getBounds().width, lawnmower.getBounds().height);
      }
    });

    cellMaps.forEach((key, value) -> {
      g.drawImage(value.getImage(), key.x + value.adjustX(), key.y + value.adjustY(), null);
      value.Stuffs.forEach(stuff -> {
        g.drawImage(stuff.getImage(), stuff.getX(), stuff.getY(), null);
        if (testMode) {
          g.drawRect(stuff.getBounds().x, stuff.getBounds().y, stuff.getBounds().width, stuff.getBounds().height);
        }
      });
    });

    level.movableEntities.forEach((stuff) -> {
      g.drawImage(stuff.getImage(), stuff.getX(), stuff.getY(), null);
      if (testMode) {
        g.drawRect(stuff.getBounds().x, stuff.getBounds().y, stuff.getBounds().width, stuff.getBounds().height);
      }
    });

    /* Zombie Dying gif */
    level.zombieKilledPosition.forEach(
        (pos, index) -> {
          if (index < visualMode.ZombieDie.length) {
            g.drawImage(visualMode.ZombieDie[index], pos.x - 30, pos.y - 30, null);
            if (LoopCounter % 4 == 0) {
              level.zombieKilledPosition.replace(pos, level.zombieKilledPosition.get(pos) + 1);
            }
          }
        });

    level.zombies.forEach((zombie) -> {
      g.drawImage(zombie.getImage(), zombie.getX(), zombie.getY() - visualMode.GameDim.height / 50, null);
      if (testMode) {
        g.drawRect(zombie.getBounds().x, zombie.getBounds().y - visualMode.GameDim.height / 50, zombie.getBounds().width, zombie.getBounds().height);
      }
    });

    level.cards.forEach((card) -> {
      if (card.dragged) {
        g.drawImage(card.dragTarget, mouseX - card.dragTarget.getWidth(null) / 2, mouseY - card.dragTarget.getHeight(null) / 2, null);
      }
    });

    cells.forEach((cell) -> {
      if (testMode) {
        g.drawRect(cell.x, cell.y, cell.width, cell.height);
      }
    });
  }

  /* ----------ACTION HANDLERS---------- */
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    for (MovableObjects movableObjects : level.movableEntities) {
      if (movableObjects instanceof Sun) {
        if (movableObjects.getBounds().contains(mouseEvent.getPoint())) {
          ((Sun) movableObjects).collected = true;
        }
      } else if (movableObjects instanceof LuckyBalloon) {
        if (movableObjects.getBounds().contains(mouseEvent.getPoint())) {
          ((LuckyBalloon) movableObjects).luckyEffect();
        }
      }

      if (mouseEvent.getSource().equals(message)) {
        if (message.getText().equals("GAME OVER") || message.getText().equals("CONGRATULATION")) {
          int opt = 0;
          UIManager.put("OptionPane.minimumSize", new Dimension(400, 100));
          if (gameResult == RESULT.WIN) {
            opt = JOptionPane
                .showOptionDialog(this, "Play again or stop here", "You conquered the game",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new String[]{"Replay", "Stop"}, 0);
          } else if (gameResult == RESULT.LOSE) {
            opt = JOptionPane
                .showOptionDialog(this, "Play again to be a winner or stop as a loser", "Your journey ended early",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new String[]{"Replay", "Stop"}, 0);
          }
          if (opt == 0) {
            Sun.updateCount(-Sun.Count);
            Sun.CountLabel.setText(String.valueOf(Sun.Count));
            resetToLevel(1);
          } else if (opt == 1) {
            System.exit(0);
          }
        }
      }
    }

    cellMaps.forEach((point, plant) -> plant.Stuffs.forEach(stuff -> {
      if (stuff instanceof Sun) {
        if (stuff.getBounds().contains(mouseEvent.getPoint())) {
          ((Sun) stuff).collected = true;
        }
      }

//j
    }));
  }

  @Override
  public void mouseReleased(MouseEvent mouseEvent) {
    if (mouseEvent.getSource() instanceof IconButton) {
      IconButton source = (IconButton) mouseEvent.getSource();
      source.dragged = false;

      for (Rectangle cell : cells) {
        if (cell.contains(mouseX, mouseY)) {
          if (source.dragTarget.equals(visualMode.ShovelImage)) {
            cellMaps.remove(cell.getLocation());
          } else {
            for (Class<? extends Plant> plantClass : level.plantClasses) {
              try {
                Plant tmp_plant = plantClass.getConstructor(int.class, int.class).newInstance(cell.x, cell.y);
                if (tmp_plant.getImage().equals(source.dragTarget)) {
                  if (Sun.Count >= tmp_plant.price) {
                    Plant hasPlant = cellMaps
                        .putIfAbsent(cell.getLocation(), plantClass.getConstructor(int.class, int.class).newInstance(cell.x, cell.y));
                    if (hasPlant == null) {
                      Sun.updateCount(-tmp_plant.price);
                    }
                  } else {
                    popup_loop_counter = LoopCounter;
                    if (message.getText().equals("")) {
                      message.setText("You don't have enough suns.");
                    }
                  }
                  break;
                }
              } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
                e.printStackTrace();
              }
            }
            break;
          }
        }
      }
    }
  }

  @Override
  public void mousePressed(MouseEvent mouseEvent) {

  }

  enum RESULT {WIN, LOSE}

  @Override
  public void mouseEntered(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseExited(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseDragged(MouseEvent mouseEvent) {
    for (IconButton card : level.cards) {
      card.dragged = mouseEvent.getSource() == card;
    }

    mouseX = mouseEvent.getX() + mouseEvent.getComponent().getX();
    mouseY = mouseEvent.getY() + mouseEvent.getComponent().getY();
    repaint();
  }

  @Override
  public void mouseMoved(MouseEvent mouseEvent) {

  }
}
