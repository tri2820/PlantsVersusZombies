package remake.entities.plants;

import java.awt.Image;
import java.util.LinkedList;
import remake.entities.stuffs.Pea;
import remake.entities.stuffs.Stuff;
import remake.entities.zombies.Zombie;

public class PeaShooter extends Plant {

  public PeaShooter(int x, int y) {
    super(x, y);
    price = 100;
    health = 100;
  }

  public LinkedList<Zombie> zomOnLane() {
    LinkedList<Zombie> ZomOnLane = new LinkedList<>();
    for (Zombie zombie : gamePanel.level.zombies) {
      if (zombie.getX() > position.x) {
        if ((zombie.getY() + visualMode.GameDim.height / 67) == position.y && zombie.getX() <= visualMode.GameDim.width) {
          ZomOnLane.add(zombie);
        }
      }
    }
    return ZomOnLane;
  }

  public Zombie closestZom(LinkedList<Zombie> ZomOnLane) {
    Zombie closestZomOnLane = ZomOnLane.getFirst();
    for (Zombie zombie : ZomOnLane) {
      if (zombie.getX() < closestZomOnLane.getX()) {
        closestZomOnLane = zombie;
      }
    }

    return closestZomOnLane;
  }

  public void shoot() {
    stuffs.add(new Pea(position.x + stuffShooter.x, position.y + stuffShooter.y));
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
}
