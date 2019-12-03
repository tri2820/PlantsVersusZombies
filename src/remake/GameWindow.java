package remake;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GameWindow extends JFrame {

  public GameWindow() {
    initUI();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        GameWindow ex = new GameWindow();
        ex.setVisible(true);
      }
    });
  }

  private void initUI() {
    add(new Game_Old());
    pack();
    setTitle("Plants Versus Zombies Clone");
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
  }
}
