package entity;

import component.Position;

public class SunFlower extends Plant {

  public SunFlower(int x, int y, int health) {
    super(x, y, health);
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
