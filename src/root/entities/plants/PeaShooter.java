package root.entities.plants;

import root.entities.Actable;
import root.entities.stuffs.Pea;
import root.entities.stuffs.Stuff;
import root.entities.zombies.Zombie;

import java.awt.*;

public class PeaShooter extends Plant implements PlantAttackable, Actable {

  public PeaShooter(int x, int y) {
    super(x, y);
    price = 100;
    health = 200;
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
      if (stuffs.isEmpty() && LoopCounter % 100 == 0) { shoot(); }
      dealWithZom();
    }
  }
}
