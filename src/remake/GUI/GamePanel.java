package remake.GUI;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import remake.GameMode.Levels.Level;
import remake.GameMode.Levels.Round1;
import remake.GameMode.Visuals.NoScalingMode;
import remake.GameMode.Visuals.VisualMode;
import remake.entities.GameEntity;
import remake.entities.plants.Plant;
import remake.entities.stuffs.HeadlessSun;
import remake.entities.stuffs.Pea;
import remake.entities.stuffs.Stuff;
import remake.entities.stuffs.Sun;
import remake.entities.zombies.Zombie;
import remake.etc.CellsManager;
import remake.etc.Constants;

public class GamePanel extends JPanel implements Runnable, MouseInputListener, CellsManager, Constants {

  public VisualMode visualMode = new NoScalingMode();
  public Level level = new Round1(this);
  /* ----------VARS---------- */
  int mouseX, mouseY;
  int LoopCounter = 0;
  boolean testMode = true;

  /* ----------INIT---------- */
  public GamePanel() {
    initGame();
    initShop();
    addMouseListener(this);
    addMouseMotionListener(this);
    setLayout(null);
    setPreferredSize(visualMode.GameDim);
  }

  void initGame() {
    CellsManager.init(visualMode);
  }

  void initShop() {
    Sun.customizeCountLabel(testMode);
    add(Sun.CountLabel);
    for (IconButton card : level.cards) {
      add(card);
    }
  }

  @Override
  public void addNotify() {
    super.addNotify();

    Thread animator = new Thread(this);
    animator.start();
  }

  /* ----------LOOP---------- */
  private void cycle() {
    /* -----Make certain things do their step----- */
    level.stuffs.forEach(Stuff::actions);
    level.zombies.forEach(Zombie::actions);

    /* ----- Recursive things ----- */
    cellMaps.forEach((Point, value) -> {
      value.actions();
      value.stuffs.forEach(GameEntity::actions);
      value.stuffs.removeIf(
          stuff -> (stuff instanceof Sun && (stuff.LoopCounter == Sun.existLoop || ((Sun) stuff).doneCollected) || ((stuff instanceof Pea) && (
              (((Pea) stuff).hitted) || ((Pea) stuff).outOfGame))));
    });


    /* ----Check for removals---- */
    level.zombies.removeIf(zombie -> zombie.health <= 0);
    level.stuffs
        .removeIf(stuff -> (stuff instanceof Sun && (stuff.LoopCounter == Sun.existLoop || ((Sun) stuff).doneCollected)));
    CellsManager.cellMaps.values().removeIf(plant -> plant.health == 0);
    /* -----Tasks that need timer----- */
    LoopCounter++;

    if (LoopCounter % 200 == 0) {
      int edge = visualMode.SunImage.getWidth(null);
      level.stuffs.add(new HeadlessSun((new Random().nextInt(visualMode.GameDim.width - 2 * edge + 1)) + edge, 0));
    }

    if (LoopCounter == 500) {
      new SimpleMessagePane("Hey, a big wave of zombies is comming.", this, SOL_FONT, Font.BOLD, 20);
    }
    if (LoopCounter == 600) {
      new SimpleMessagePane("Try to protect your house.", this, SOL_FONT, Font.BOLD, 20);
    }
    if (LoopCounter == 700) {
      new SimpleMessagePane("Good luck! ^^", this, SOL_FONT, Font.BOLD, 20);
    }

    if (!level.end()) {
      if (LoopCounter > 0 && LoopCounter % 200 == 0) {
        level.addZombie(visualMode);
      }
    } else {
      if (level.zombies.isEmpty()) {
        new SimpleMessagePane("Well done!", this, SOL_FONT, Font.BOLD, 20);
      }
    }
  }

  @Override
  public void run() {
    long beforeTime, timeDiff, sleep;

    beforeTime = System.currentTimeMillis();

    while (true) {

      cycle();
      repaint();

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
    for (int lane : lanes) {
      g.drawImage(visualMode.LawnmowerImage, 0, lane + 20, this);
    }

    cellMaps.forEach((key, value) -> {
      g.drawImage(value.getImage(), key.x, key.y, null);
      value.stuffs.forEach(stuff -> {
        g.drawImage(stuff.getImage(), stuff.getX(), stuff.getY(), null);
        if (testMode) {
          g.drawRect(stuff.getBounds().x, stuff.getBounds().y, stuff.getBounds().width, stuff.getBounds().height);
        }
      });
    });

    level.stuffs.forEach((stuff) -> {
      g.drawImage(stuff.getImage(), stuff.getX(), stuff.getY(), null);
      if (testMode) {
        g.drawRect(stuff.getBounds().x, stuff.getBounds().y, stuff.getBounds().width, stuff.getBounds().height);
      }
    });

    level.zombies.forEach((zombie) -> {
      g.drawImage(zombie.getImage(), zombie.getX(), zombie.getY(), null);
      if (testMode) {
        g.drawRect(zombie.getBounds().x, zombie.getBounds().y, zombie.getBounds().width, zombie.getBounds().height);
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
    for (Stuff stuff : level.stuffs) {
      if (stuff instanceof Sun) {
        if (stuff.getBounds().contains(mouseEvent.getPoint())) {
          ((Sun) stuff).collected = true;
        }
      }
    }

    cellMaps.forEach((point, plant) -> plant.stuffs.forEach(stuff -> {
      if (stuff instanceof Sun) {
        if (stuff.getBounds().contains(mouseEvent.getPoint())) {
          ((Sun) stuff).collected = true;
        }
      }
    }));
  }

  @Override
  public void mousePressed(MouseEvent mouseEvent) {

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
                    cellMaps.putIfAbsent(cell.getLocation(), plantClass.getConstructor(int.class, int.class).newInstance(cell.x, cell.y));
                    Sun.updateCount(-tmp_plant.price);
                  } else {
                    new SimpleMessagePane(
                        "Poor you! You don't have enough suns.", this, SOL_FONT, Font.BOLD, 20);
                  }
                  break;
                }
              } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
                e.printStackTrace();
              }
            }
          }
        }
      }
    }
  }

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
