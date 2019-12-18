package root.entities.plants;

import java.awt.Image;
import root.entities.stuffs.Pea;
import root.entities.stuffs.Stuff;
import root.entities.zombies.Zombie;

public class PeaShooter extends Plant implements PlantAttackable {

  public PeaShooter(int x, int y) {
    super(x, y);
    price = 100;
    health = 100;
  }


  @Override
  public void shoot() {
    stuffs.add(new Pea(position.x + stuffShooter.x, position.y + stuffShooter.y));
  }


  @Override
  public void dealWithZom() {
    Zombie closestZom = closestZom(zomOnLane());
    for (Stuff stuff : stuffs) {
      if (closestZom.getX() - stuff.getX() < closestZom.getImage().getWidth(null) / 4) {
        ((Pea) stuff).hitted = true;
        closestZom.health -= 10;
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
      if (stuffs.isEmpty() && LoopCounter % 20 == 0) {
        shoot();
      }
      dealWithZom();
    }
  }
}
