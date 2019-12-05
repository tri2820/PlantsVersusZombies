package minimalRemake.GUI;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import minimalRemake.Base.Commons;
import minimalRemake.Base.GameEntities;
import minimalRemake.Plants.PeaShooter;
import minimalRemake.Plants.Sun;

public class Game extends JPanel implements Runnable, MouseListener, MouseMotionListener {

  // GUI components
  JLabel sunCountLabel;
  IconButton FreezePeaShooterBT;
  IconButton PeaShooterBT;
  IconButton SunFlowerBT;
  IconButton digBT;
  IconButton[] buttons = new IconButton[3];

  // flags

  // Some control numbers
  int sunCount = 0;
  private int mouseX, mouseY;
  private final int DELAY = 25;
  int numOfSuns = 10;
  int numOfPeaShooters = 45;

  ArrayList<GameEntities> entities = new ArrayList<>(30);

  public Game() {
    initGame();
    addMouseListener(this);
    addMouseMotionListener(this);
    setLayout(null);
    setPreferredSize(Commons.GameDim);
    setUpShop();
  }

  private void initGame() {
    Commons.init();
    for (int i = 0; i < numOfSuns; i++)
      entities.add(new Sun());

    for (int i = 0; i < Commons.cols.length; i++) {
      for (int j = 0; j < Commons.lanes.length; j++) {
        PeaShooter peaShooter = new PeaShooter(Commons.cols[i], Commons.lanes[j]);
        entities.add(peaShooter);
        entities.addAll(Arrays.asList(peaShooter.peas));
      }
    }
  }

  private void setUpShop() {
    buttons[0] = new IconButton(Commons.SunFlowerCard, Commons.GameDim.width * 10 / 90, Commons.GameDim.height / 67, Commons.SunFlower, this);
    buttons[1] = new IconButton(Commons.PeaShooterCard, Commons.GameDim.width * 16 / 90, Commons.GameDim.height / 67, Commons.PeaShooter, this);
    buttons[2] = new IconButton(Commons.FreezePeaShooterCard, Commons.GameDim.width * 22 / 90, Commons.GameDim.height / 67, Commons.FreezePeaShooter,
        this);

    for (IconButton ib : buttons) {
      if (ib != null) {
        add(ib);
        ib.addMouseMotionListener(this);
      }
    }

    add(sunCountLabel = new JLabel(String.valueOf(sunCount)));
    sunCountLabel.setBounds(
        Commons.GameDim.width * 4 / 90, Commons.GameDim.height * 4 / 67, 100, 100);
    sunCountLabel.setFont(new Font("Verdana", Font.PLAIN, 18));

  }

  // Do every step of the game here
  private void cycle() {
    for (GameEntities e : entities)
      e.actions();
  }

  // Draw the game
  @Override
  public void paintComponent(Graphics g) {
    g.drawImage(Commons.Background, 0, 0, null);
    for (GameEntities e : entities) {
      if (e.visible) {
        g.drawImage(e.getImage(), e.position.x, e.position.y, null);
        Rectangle r = e.getBounds();
        g.drawRect(r.x, r.y, r.width, r.height);
      }
    }

    for (IconButton ib : buttons) {
      if (ib.dragged) {
        g.drawImage(ib.dragTarget, mouseX - ib.dragTarget.getWidth(null) / 2, mouseY - ib.dragTarget.getHeight(null) / 2, null);
      }
    }
  }

  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
        for (var e : entities) {
          if (e.getBounds().contains(mouseEvent.getPoint())) {
            if (e instanceof Sun) {
              sunCountLabel.setText(String.valueOf(sunCount += 25));
            }
          }
        }
  }

  @Override
  public void mousePressed(MouseEvent mouseEvent) {}

  @Override
  public void mouseReleased(MouseEvent mouseEvent) {
    if (mouseEvent.getSource() instanceof IconButton) {
      for (GameEntities e : entities) {
        if (e.getBounds().contains(mouseX, mouseY)) {
          if (e instanceof PeaShooter) {
            e.visible = true;
            try {
              mouseEvent.getSource().getClass().getField("dragged").set(mouseEvent.getSource(), false);
            } catch (NoSuchFieldException | IllegalAccessException ex) {
              ex.printStackTrace();
            }
          }
        }
      }
    }
  }

  @Override
  public void mouseEntered(MouseEvent mouseEvent) {}

  @Override
  public void mouseExited(MouseEvent mouseEvent) {}

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
  public void mouseMoved(MouseEvent mouseEvent) {}

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
