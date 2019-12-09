package PvZ.Plants;

import PvZ.Base.GameEntities;
import java.awt.Image;
import java.awt.Rectangle;

public class FreezePea extends GameEntities {

  boolean wasInvisible = false;
  GameEntities owner = null;

  int dx = level.BulletSpeedX;
  int dy = level.BulletSpeedY;

  int x_initial = 0;
  int y_initial = 0;

  public FreezePea(int x, int y, GameEntities owner) {
    super(x, y);
    x_initial = x;
    y_initial = y;
    this.owner = owner;
  }

  public void reset() {
    position.x = x_initial;
    position.y = y_initial;
  }

  @Override
  public void actions() {
    if (owner.visible) {
      if (!visible) {
        wasInvisible = true;
        if (luck.nextBoolean()) {
          visible = true;
        }
      } else {
        position.x += dx;
        position.y += dy;
      }
      if (visible && wasInvisible) {
        reset();
        wasInvisible = false;
      }
      if (position.x > visual.GameDim.width
          || position.y > visual.GameDim.height
          || position.y < 0) {
        visible = false;
        reset();
      }
    } else {
      visible = false;
    }
  }

  @Override
  public Rectangle getBounds() {
    return new Rectangle(
        position.x, position.y, getImage().getWidth(null), getImage().getHeight(null));
  }

  @Override
  public Image getImage() {
    return visual.FreezePeaImage;
  }
}
