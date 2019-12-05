package minimalRemake.Plants;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import minimalRemake.Base.Commons;
import minimalRemake.Base.GameEntities;

public class PeaShooter extends GameEntities {

  public Pea[] peas = new Pea[1];
  //  Instant start;
  Point gun = new Point(getBounds().width * 5 / 7, getBounds().height / 10);

  public PeaShooter(int x, int y) {
    super(x, y);
    initBullet();
    visible = false;
  }

  public void initBullet() {
    for (int i = 0; i < peas.length; i++) {
      peas[i] = new Pea(getGun().x, getGun().y, this);
    }
  }

  public Point getGun() {
    return new Point(position.x + gun.x, position.y + gun.y);
  }

  @Override
  public Rectangle getBounds() {
    return new Rectangle(position.x, position.y, getImage().getWidth(null), getImage().getHeight(null));
  }

  @Override
  public Image getImage() {
    return Commons.PeaShooter;
  }

  @Override
  public void actions() {}
}
