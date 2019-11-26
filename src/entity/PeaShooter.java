package entity;

import component.Position;
import component.Shoot;

public class PeaShooter extends Plant implements Shoot {

  public PeaShooter(int x, int y, int health) {
    super(x, y, health);
  }

  @Override
  public Pea shoot() {
    Position pos = this.getSingleComponent(Position.class);
    Pea pea = new Pea(pos.getX(), pos.getY(), 1, 5);
    return pea;
  }
}
