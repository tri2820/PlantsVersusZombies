package root.entities.plants;

import java.awt.Image;
import root.entities.movable.HeadedSun;

public class SunFlower extends Plant {

  public SunFlower(int x, int y) {
    super(x, y);
    price = 50;
    health = 200;
  }

  @Override
  public void actions() {
    LoopCounter++;
    if (LoopCounter % 256 == 0) {
      Stuffs.add(new HeadedSun(position.x + stuffShooter.x, position.y + stuffShooter.y));
    }
  }

  @Override
  public Image getImage() {
    return visualMode.SunFlowerImage;
  }
}
