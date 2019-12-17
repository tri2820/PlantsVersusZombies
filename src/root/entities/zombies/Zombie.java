package root.entities.zombies;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import root.entities.GameEntity;
import root.entities.plants.Plant;
import root.etc.CellsManager;

public abstract class Zombie extends GameEntity {

  public static JLabel Status = new JLabel();
  public int health;
  public boolean stunt = false;

  public Zombie(int x, int y) {
    super(x, y);
    dx = -1;
    dy = 0;
  }

  public static JLabel initStatus() {
    Status.setBounds(CellsManager.cols[8] + 10, 0, 100, 30);
    if (gamePanel.testMode) {
      Status.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    Status.setFont(visualMode.SOL_FONT.deriveFont(20f));
    Status.setForeground(Color.BLACK);
    Status.setHorizontalAlignment(SwingConstants.CENTER);
    return Status;
  }

  public static void updateStatus() {
    String status = String.format("%d/%d", gamePanel.level.MAX_ZOMBIES - gamePanel.level.zombieCount, gamePanel.level.MAX_ZOMBIES);
    Status.setText(status);
  }

  @Override
  public void actions() {
    LoopCounter++;
    position.y += dy;

    Plant collidedPlant = collidedPlant();
    if (collidedPlant == null) {
      if (!stunt) {
        position.x += dx;
      } else {
        if (LoopCounter % 80 == 0) {
          stunt = false;
        }
      }
    } else {
      collidedPlant.health -= 1;
    }
  }

  private Plant collidedPlant() {
    if (!CellsManager.cellMaps.isEmpty()) {
      for (Plant p : CellsManager.cellMaps.values()) {
        if (position.y == p.getY()) {
          if (Math.abs(position.x - (p.getX() + p.getImage().getWidth(null))) < Math.abs(dx)) {
            return p;
          }
        }
      }
    }
    return null;
  }
}
