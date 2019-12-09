package PvZ.Base;

import PvZ.Commons;
import PvZ.GameMode.Level;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class GameEntities implements Commons {

  protected static Level level;
  public Point position;
  public boolean visible = false;
  public int price;

  public abstract void actions();

  public abstract Rectangle getBounds();

  public abstract Image getImage();

  protected GameEntities() {
  }

  public GameEntities(int x, int y) {
    position = new Point(x, y);
  }

  public static void setLevel(Level level) {
    GameEntities.level = level;
  }
}
