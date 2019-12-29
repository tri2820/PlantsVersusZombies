package root.entities.zombies;

import java.awt.Color;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import root.entities.Actable;
import root.entities.GameEntity;
import root.entities.plants.Plant;
import root.etc.CellsManager;

public abstract class Zombie extends GameEntity implements Actable {

  public static JLabel Status = new JLabel();
  public int health;
  public boolean slowed = false;
  public boolean collided = false;
  public int speed = 0;

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
    String status = String.format("%d/%d", gamePanel.level.MAX_ZOMBIES - gamePanel.level.zombieKilled, gamePanel.level.MAX_ZOMBIES);
    Status.setText(status);
  }

  @Override
  public void actions() {
    LoopCounter++;

    Plant collidedPlant = collidedPlant();
    if (collidedPlant == null) {
      collided = false;
      if (!slowed) {
        speed = 2;
      } else {
        speed = 1;
        if (LoopCounter % 128 == 0) {
          slowed = false;
        }
      }
      position.x += dx * speed;
      position.y += dy * speed;
    } else {
      collidedPlant.health -= 1;
      collided = true;
    }

  }

  protected Plant collidedPlant() {
    if (!CellsManager.cellMaps.isEmpty()) {
      for (Plant p : CellsManager.cellMaps.values()) {
        if (Math.abs(position.y - p.getY()) <= 10) {
          if (Math.abs(position.x - (p.getX() + p.getImage().getWidth(null))) < Math.abs(dx + 10)) {
            return p;
          }
        }
      }
    }
    return null;
  }

  public Point getPosition() {
    return this.position;
  }
}
