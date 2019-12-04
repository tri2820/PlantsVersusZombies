package minimalRemake.Plants;

import java.awt.Image;
import java.awt.Rectangle;
import minimalRemake.Base.Commons;
import minimalRemake.Base.GameEntities;

public class Pea extends GameEntities {
  int dx = 1;
  int dy = 0;

  public Pea(int x, int y) {
    super(x, y);
  }

  @Override
  public void actions() {
    position.x += dx;
    position.y += dy;
  }

  @Override
  public Rectangle getBounds() {
    return new Rectangle(position.x, position.y, getImage().getWidth(null), getImage().getHeight(null));
  }

  @Override
  public Image getImage() {
    return Commons.Pea;
  }

}
