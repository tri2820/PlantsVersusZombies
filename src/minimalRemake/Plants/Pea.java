package minimalRemake.Plants;

import java.awt.Image;
import java.awt.Rectangle;
import minimalRemake.Base.Commons;
import minimalRemake.Base.GameEntities;

public class Pea extends GameEntities {

  boolean wasInvisible = false;
  PeaShooter owner = null;

  int dx = 3;
  int dy = 0;

  int x_initial = 0;
  int y_initial = 0;

  public Pea(int x, int y, PeaShooter owner) {
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
        if (Commons.luck.nextBoolean()) {
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
      if (position.x > Commons.GameDim.width
          || position.y > Commons.GameDim.height
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
    return Commons.Pea;
  }
}
