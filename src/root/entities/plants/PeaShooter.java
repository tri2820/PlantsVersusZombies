package root.entities.plants;

import java.awt.Image;
import root.entities.PlantAttackable;
import root.entities.movable.MovableObjects;
import root.entities.movable.Pea;
import root.entities.zombies.Zombie;

public class PeaShooter extends Plant implements PlantAttackable {

  public PeaShooter(int x, int y) {
    super(x, y);
    price = 100;
    health = 200;
  }


  @Override
  public void shoot() {
    Stuffs.add(new Pea(position.x + stuffShooter.x, position.y + stuffShooter.y));
  }


  @Override
  public void dealWithZom() {
    Zombie closestZom = closestZom(zomOnLane());
    for (MovableObjects movableObjects : Stuffs) {
      if (closestZom.getX() - movableObjects.getX() < closestZom.getImage().getWidth(null) / 4) {
        ((Pea) movableObjects).hitted = true;
        closestZom.health -= 15;
      }
    }
  }

  @Override
  public Image getImage() {
    return visualMode.PeaShooterImage;
  }

 @Override
  public void actions() {
    LoopCounter++;
    if (!zomOnLane().isEmpty()) {
      if (LoopCounter % 12 == 0) {
        shoot();
      }
      dealWithZom();
    }
  }
}
