package PvZ.Base;

import PvZ.GameMode.Level;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class GameEntities implements Commons {

  public Point position;
  protected static Level lv;
  public boolean visible = false;
  public int price;

  public static void setLevel(Level lv) {
    GameEntities.lv = lv;
  }


  public abstract void actions();

  public abstract Rectangle getBounds();

  public abstract Image getImage();

  protected GameEntities() {
  }

  public GameEntities(int x, int y) {
    position = new Point(x, y);
  }
}
