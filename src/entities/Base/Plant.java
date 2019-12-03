package entities.Base;

import components.Collision;
import components.Health;
import components.Position;
import components.Visual;
import java.util.ArrayList;
import java.util.List;

/// Not all plants move => plant base class will not implement Move interface
public abstract class Plant extends Entity {

  public Plant() {}

  /*
   * Initialize a bullet with a given position
   * This is used to initialize the bullet when it is first spawn from a Plant
   */
  public Plant(int x, int y, int health, String ImagePath) {
    this.addComponent(new Visual(ImagePath));
    this.addComponent(new Position(x, y));
    this.addComponent(new Collision(new ArrayList<>(List.of(Zombie.class))));
    this.addComponent(new Size(10, 10));
    this.addComponent(new Health(health));
  }
}
