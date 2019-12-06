package PvZ;

import PvZ.GUI.Game;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

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
    add(Game.getInstance());
    pack();
    setTitle("Plants Versus Zombies Clone");
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
  }
}
