package PvZ.Plants;

import PvZ.Base.GameEntities;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

public class SunFlower extends GameEntities {

  public Sun[] suns = new Sun[1];
  Point gun = new Point(getBounds().width * 5 / 7, getBounds().height / 10);

  public SunFlower(int x, int y) {
    super(x, y);
    initSun();
    price = level.Price_SunFlower;
  }

  public void initSun() {
    for (int i = 0; i < suns.length; i++) {
      suns[i] = new Sun(getGun().x, getGun().y, this);
    }
  }

  public Point getGun() {
    return new Point(position.x + gun.x, position.y + gun.y);
  }


  @Override
  public void actions() {
  }

  @Override
  public Rectangle getBounds() {
    return new Rectangle(position.x, position.y, getImage().getWidth(null), getImage().getHeight(null));
  }

  @Override
  public Image getImage() {
    return visual.SunFlowerImage;
  }
}
