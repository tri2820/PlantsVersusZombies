package entities.Zombies;

import components.Position;
import entities.Base.Plant;
import entities.Bullets.Sun;

public class SunFlower extends Plant {

  public SunFlower(int x, int y, int health, String imagePath) {
    super(x, y, health, imagePath);
  }

  /*
   * return Sun object created
   */
  public Sun generateSunAtCurrentPosition() {
    Sun generated_sun = new Sun(this.getSingleComponent(Position.class).getX(),
        this.getSingleComponent(Position.class).getY());
    return generated_sun;
  }
}
