package PvZ.Zombies;

import PvZ.Base.GameEntities;
import java.awt.Image;
import java.awt.Rectangle;

public class NormalZombie extends GameEntities {

  @Override
  public void actions() {

  }

  @Override
  public Rectangle getBounds() {
    return new Rectangle(position.x, position.y, getImage().getWidth(null), getImage().getHeight(null));
  }

  @Override
  public Image getImage() {
    return NormalZombieImage;
  }
}
