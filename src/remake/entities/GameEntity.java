package remake.entities;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import remake.GUI.GamePanel;
import remake.GameMode.Visuals.VisualMode;
import remake.etc.Constants;

public abstract class GameEntity implements Constants {

  protected static VisualMode visualMode;
  protected static GamePanel gamePanel;
  public int dx;
  public int dy;
  public int LoopCounter = 0;
  protected Point position;

  public GameEntity() {
  }

  public GameEntity(int x, int y) {
    position = new Point(x, y);
  }

  public static void setGamePanel(GamePanel gamePanel) {
    GameEntity.gamePanel = gamePanel;
  }

  public static void setVisualMode() {
    GameEntity.visualMode = gamePanel.visualMode;
  }

  public int getX() {
    return position.x;
  }

  public int getY() {
    return position.y;
  }

  public Rectangle getBounds() {
    assert getImage() != null;
    return new Rectangle(
        position, new Dimension(getImage().getWidth(null), getImage().getHeight(null)));
  }

  public abstract void actions();

  public abstract Image getImage();
}
