package root.entities.stuffs;

import java.awt.Image;
import root.entities.plants.Plant;

public class SunFlower extends Plant {

  public SunFlower(int x, int y) {
    super(x, y);
    price = 50;
    health = 50;
  }

  @Override
  public void actions() {
    LoopCounter++;
    if (LoopCounter % 250 == 0) {
      stuffs.add(new HeadedSun(position.x + stuffShooter.x, position.y + stuffShooter.y));
    }
  }

  @Override
  public Image getImage() {
    return visualMode.SunFlowerImage;
  }
}
