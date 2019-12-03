package entities.Zombies;

import components.Position;
import components.Interfaces.Shoot;
import entities.Base.Plant;
import entities.Bullets.FreezePea;
import entities.Bullets.Pea;

public class FreezePeaShooter extends Plant implements Shoot {

  public FreezePeaShooter(int x, int y, int health, String imagePath) {
    super(x, y, health, imagePath);
  }

  @Override
  public Pea shoot() {
    Position pos = this.getSingleComponent(Position.class);
    FreezePea pea = new FreezePea(pos.getX(), pos.getY(), 1, 7);
    return pea;
  }
}
