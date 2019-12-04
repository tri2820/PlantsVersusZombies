package minimalRemake.Base;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class GameEntities {
  public Point position;
  public boolean visible = false;

  public abstract void actions();
  public abstract Rectangle getBounds();
  public abstract Image getImage();

  protected GameEntities() {}

  public GameEntities(int x, int y) {
    position = new Point(x, y);
  }
}
