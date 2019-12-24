package root.entities.stuffs;

import root.entities.Actable;
import root.entities.plants.Plant;

import java.awt.*;

public class SunFlower extends Plant implements Actable {

  public SunFlower(int x, int y) {
    super(x, y);
    price = 50;
    health = 200;
  }

  @Override
  public void actions() {
    LoopCounter++;
    if (LoopCounter % 500 == 0) {
      stuffs.add(new HeadedSun(position.x + stuffShooter.x, position.y + stuffShooter.y));
    }
  }

  @Override
  public Image getImage() {
    return visualMode.SunFlowerImage;
  }
}
