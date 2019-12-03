package entities.Zombies;

import components.Position;
import components.Interfaces.Shoot;
import entities.Base.Plant;
import entities.Bullets.Pea;

public class PeaShooter extends Plant implements Shoot {

  public PeaShooter(int x, int y, int health, String imagePath) {
    super(x, y, health, imagePath);
  }

  @Override
  public Pea shoot() {
    Position pos = this.getSingleComponent(Position.class);
    Pea pea = new Pea(pos.getX(), pos.getY(), 1, 5);
    return pea;
  }
}
