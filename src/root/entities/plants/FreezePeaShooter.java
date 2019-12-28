package root.entities.plants;

import java.awt.Image;
import root.entities.PlantAttackable;
import root.entities.movable.FreezePea;
import root.entities.movable.MovableObjects;
import root.entities.zombies.Zombie;

public class FreezePeaShooter extends PeaShooter implements PlantAttackable {

  public FreezePeaShooter(int x, int y) {
    super(x, y);
    price = 175;
    health = 200;
  }

  @Override
  public void dealWithZom() {
    Zombie closestZom = closestZom(zomOnLane());
    for (MovableObjects movableObjects : Stuffs) {
      if (closestZom.getX() - movableObjects.getX() < closestZom.getImage().getWidth(null) / 4) {
        ((FreezePea) movableObjects).hitted = true;
        closestZom.slowed = true;
        closestZom.health -= 15;
      }
    }
  }

  @Override
  public void shoot() {
    Stuffs.add(new FreezePea(position.x + stuffShooter.x, position.y + stuffShooter.y));
  }

  @Override
  public Image getImage() {
    return visualMode.FreezePeaShooterImage;
  }
}
