package root;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import root.GUI.GamePanel;

public class PlantsVsZombies extends JFrame {

  public PlantsVsZombies() {
    initUI();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        PlantsVsZombies game = new PlantsVsZombies();
        game.setVisible(true);
      }
    });
  }

  private void initUI() {
//    add(Game.getInstance());
    add(new GamePanel());
    pack();
    setTitle("Plants Versus Zombies Clone");
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
  }
}
