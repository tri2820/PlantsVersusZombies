package PvZ.Plants;

import PvZ.Base.GameEntities;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

public class FreezePeaShooter extends GameEntities {

  public FreezePea[] freezePeas = new FreezePea[1];
  Point gun = new Point(getBounds().width * 5 / 7, getBounds().height / 10);

  public FreezePeaShooter(int x, int y) {
    super(x, y);
    initBullet();
    price = lv.Price_FreezePeaShooter;
  }

  public void initBullet() {
    for (int i = 0; i < freezePeas.length; i++) {
      freezePeas[i] = new FreezePea(getGun().x, getGun().y, this);
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
    return FreezePeaShooterImage;
  }

  @Override
  public void actions() {
  }
}
