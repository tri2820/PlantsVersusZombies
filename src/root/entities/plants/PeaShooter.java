package root.entities.plants;

import root.entities.PlantAttackable;
import root.entities.moveable.MoveableObjects;
import root.entities.moveable.Pea;
import root.entities.zombies.Zombie;

import java.awt.*;

public class PeaShooter extends Plant implements PlantAttackable {

  public PeaShooter(int x, int y) {
    super(x, y);
    price = 100;
    health = 200;
  }


  @Override
  public void shoot() {
    moveableEntities.add(new Pea(position.x + stuffShooter.x, position.y + stuffShooter.y));
  }


  @Override
  public void dealWithZom() {
    Zombie closestZom = closestZom(zomOnLane());
    for (MoveableObjects moveableObjects : moveableEntities) {
      if (closestZom.getX() - moveableObjects.getX() < closestZom.getImage().getWidth(null) / 4) {
        ((Pea) moveableObjects).hitted = true;
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
      if (moveableEntities.isEmpty() && LoopCounter % 100 == 0) { shoot(); }
      dealWithZom();
    }
  }
}
