package root.entities;

import java.awt.*;

import root.GUI.GamePanel;
import root.GameMode.Visuals.VisualMode;
import root.etc.Constants;

public abstract class GameEntity implements Constants {

  protected static VisualMode visualMode;
  protected static GamePanel gamePanel;
  public double dx;
  public double dy;
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

  public abstract Image getImage();
}
