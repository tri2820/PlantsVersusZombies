package root.entities.plants;

import root.entities.PlantAttackable;
import root.entities.stuffs.FreezePea;
import root.entities.stuffs.MoveableEntity;
import root.entities.zombies.Zombie;

import java.awt.*;

public class FreezePeaShooter extends PeaShooter implements PlantAttackable {

  public FreezePeaShooter(int x, int y) {
    super(x, y);
    price = 175;
    health = 200;
  }

  @Override
  public void dealWithZom() {
    Zombie closestZom = closestZom(zomOnLane());
    for (MoveableEntity moveableEntity : moveableEntities) {
      if (closestZom.getX() - moveableEntity.getX() < closestZom.getImage().getWidth(null) / 4) {
        ((FreezePea) moveableEntity).hitted = true;
        closestZom.stunt = true;
        closestZom.health -= 15;
      }
    }
  }

  @Override
  public void shoot() {
    moveableEntities.add(new FreezePea(position.x + stuffShooter.x, position.y + stuffShooter.y));
  }

  @Override
  public Image getImage() {
    return visualMode.FreezePeaShooterImage;
  }
}
