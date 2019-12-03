package remake;

import helper.Dir;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JPanel implements Runnable, MouseListener, MouseMotionListener {

  private final int DELAY = 25;
  private Dimension GameDim;
  private int lane1y, lane2y, lane3y, lane4y, lane5y;

  public Game() {
    initGame();
    addMouseListener(this);
    addMouseMotionListener(this);
    setLayout(null);
    setPreferredSize(GameDim);
  }

  private void initGame() {
    Image bg = new ImageIcon(Dir.resource + "bg.png").getImage();

    // Set Game dimension based on the background image
    GameDim = new Dimension(bg.getWidth(null), bg.getHeight(null));

    // Set coefficient to find each lane relative to the background
    lane1y = GameDim.height * 54 / 67;
    lane2y = GameDim.height * 43 / 67;
    lane3y = GameDim.height * 32 / 67;
    lane4y = GameDim.height * 21 / 67;
    lane5y = GameDim.height * 10 / 67;

  }

  // Do every step of the game here
  private void cycle() {

  }

  // Do every step of the GUI
  @Override
  public void paintComponents(Graphics g) {

  }

  @Override
  public void mouseClicked(MouseEvent mouseEvent) {

  }

  @Override
  public void mousePressed(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseReleased(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseEntered(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseExited(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseDragged(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseMoved(MouseEvent mouseEvent) {

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

        JOptionPane.showMessageDialog(this, msg, "Error",
            JOptionPane.ERROR_MESSAGE);
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
