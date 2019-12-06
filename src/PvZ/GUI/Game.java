package PvZ.GUI;

import PvZ.Base.Commons;
import PvZ.Base.GameEntities;
import PvZ.GameMode.Level;
import PvZ.GameMode.Round1;
import PvZ.Plants.FreezePeaShooter;
import PvZ.Plants.PeaShooter;
import PvZ.Plants.Sun;
import PvZ.Plants.SunFlower;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Game extends JPanel implements Runnable, MouseListener, MouseMotionListener, Commons {

  private static volatile Game game;
  private final int DELAY = 25;
  // GUI components
  IconButton[] buttons = new IconButton[4];
  // Set level using Strategy Design Pattern
  Level lv = new Round1();

  ArrayList<GameEntities> entities = new ArrayList<>(30);
  // Some control numbers
  private int mouseX, mouseY;

  private Game() {
    initGame();
    addMouseListener(this);
    addMouseMotionListener(this);
    setLayout(null);
    setPreferredSize(GameDim);
    setUpShop();
  }

  public static Game getInstance() {
    if (game == null) {
      // To make thread safe
      synchronized (Level.class) {
        // check again as multiple threads
        // can reach above step
        if (game == null) {
          game = new Game();
        }
      }
    }
    return game;
  }

  private void initGame() {
    Commons.initAll();
    GameEntities.setLevel(lv);

    for (Point cell : cells) {
      PeaShooter peaShooter = new PeaShooter(cell.x, cell.y);
      entities.add(peaShooter);
      entities.addAll(Arrays.asList(peaShooter.peas));

      FreezePeaShooter freezePeaShooter = new FreezePeaShooter(cell.x, cell.y);
      entities.add(freezePeaShooter);
      entities.addAll(Arrays.asList(freezePeaShooter.freezePeas));

      SunFlower sunFlower = new SunFlower(cell.x, cell.y);
      entities.add(sunFlower);
      entities.addAll(Arrays.asList(sunFlower.suns));
    }
    for (int i = 0; i < lv.numOfSuns; i++) {
      entities.add(new Sun());
    }
  }

  // check if a cell contains a visible entity
  public GameEntities getCellOwner(int x, int y) {
    for (GameEntities e : entities) {
      if (e.getBounds().contains(x, y) && e.visible) {
        return e;
      }
    }
    return null;
  }

  private void setUpShop() {
    buttons[0] =
        new IconButton(
            SunFlowerCardIcon, GameDim.width * 10 / 90, GameDim.height / 67, SunFlowerImage, this);
    buttons[1] =
        new IconButton(
            PeaShooterCardIcon,
            GameDim.width * 16 / 90,
            GameDim.height / 67,
            PeaShooterImage,
            this);
    buttons[2] =
        new IconButton(
            FreezePeaShooterCardIcon,
            GameDim.width * 22 / 90,
            GameDim.height / 67,
            FreezePeaShooterImage,
            this);
    buttons[3] = new IconButton(ShovelButtonIcon, GameDim.width * 57 / 100, 0, ShovelImage, this);

    for (IconButton ib : buttons) {
      if (ib != null) {
        add(ib);
        ib.addMouseMotionListener(this);
      }
    }

    add(Sun.CountLabel = new JLabel(String.valueOf(Sun.Count), SwingConstants.CENTER));
    Sun.CountLabel.setBounds(GameDim.width * 5 / 200, GameDim.height * 7 / 67, 75, 30);
    if (lv.testMode) {
      Sun.CountLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    Sun.CountLabel.setFont(new Font(SUN_COUNT_FONT, Font.BOLD, 20));
  }

  // Do every step of the game here
  private void cycle() {
    for (GameEntities e : entities) {
      e.actions();
    }
  }

  // Draw the game
  @Override
  public void paintComponent(Graphics g) {
    g.drawImage(BackgroundImage, 0, 0, null);
    for (GameEntities e : entities) {
      if (e.visible) {
        g.drawImage(e.getImage(), e.position.x, e.position.y, null);
        if (lv.testMode) {
          Rectangle r = e.getBounds();
          g.drawRect(r.x, r.y, r.width, r.height);
        }
      }
    }

    for (IconButton ib : buttons) {
      if (ib.dragged) {
        g.drawImage(
            ib.dragTarget,
            mouseX - ib.dragTarget.getWidth(null) / 2,
            mouseY - ib.dragTarget.getHeight(null) / 2,
            null);
      }
    }
  }

  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    for (GameEntities e : entities) {
      if (e.getBounds().contains(mouseEvent.getPoint())) {
        if (e instanceof Sun && e.visible) {
          ((Sun) e).collected = true;
        }
      }
    }
  }

  @Override
  public void mousePressed(MouseEvent mouseEvent) {
  }

  @Override
  public void mouseReleased(MouseEvent mouseEvent) {
    if (mouseEvent.getSource() instanceof IconButton) {
      IconButton source = (IconButton) mouseEvent.getSource();
      GameEntities owner = getCellOwner(mouseX, mouseY);
      if (owner != null) {
        owner.visible = source.dragTarget != ShovelImage;
      } else {
        for (GameEntities e : entities) {
          if (e.getBounds().contains(mouseX, mouseY) && e.getImage().equals(source.dragTarget)) {
            if (Sun.Count < e.price) {
              new SimpleMessagePane(
                  "Poor you! You don't have enough sun.", this, SUN_COUNT_FONT, Font.BOLD, 20);
            } else {
              e.visible = true;
              Sun.CountLabel.setText(String.valueOf(Sun.Count -= e.price));
            }
          }
        }
      }
      source.dragged = false;
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
    for (IconButton ib : buttons) {
      ib.dragged = mouseEvent.getSource() == ib;
    }

    mouseX = mouseEvent.getX() + mouseEvent.getComponent().getX();
    mouseY = mouseEvent.getY() + mouseEvent.getComponent().getY();
    repaint();
  }

  @Override
  public void mouseMoved(MouseEvent mouseEvent) {
  }

  // Double Checked Locking based Java implementation of
  // singleton design pattern

  // Running the game
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

  @Override
  public void addNotify() {
    super.addNotify();

    Thread animator = new Thread(this);
    animator.start();
  }
}
