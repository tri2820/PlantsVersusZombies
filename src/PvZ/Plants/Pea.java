package PvZ.Plants;

import PvZ.Base.GameEntities;
import java.awt.Image;
import java.awt.Rectangle;

public class Pea extends GameEntities {

  boolean wasInvisible = false;
  GameEntities owner = null;

  int dx = lv.BulletSpeedX;
  int dy = lv.BulletSpeedY;

  int x_initial = 0;
  int y_initial = 0;

  public Pea(int x, int y, GameEntities owner) {
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
    position.x += dx;
    position.y += dy;
    if (owner.visible) {
      if (!visible) {
        wasInvisible = true;
        visible = luck.nextBoolean();
      }
      if (visible && wasInvisible) {
        reset();
        wasInvisible = false;
      }
    } else {
      visible = false;
    }
    if (position.x > GameDim.width || position.y > GameDim.height || position.y < 0) {
      visible = false;
      reset();
    }
  }

  @Override
  public Rectangle getBounds() {
    return new Rectangle(
        position.x, position.y, getImage().getWidth(null), getImage().getHeight(null));
  }

  @Override
  public Image getImage() {
    return PeaImage;
  }
}
