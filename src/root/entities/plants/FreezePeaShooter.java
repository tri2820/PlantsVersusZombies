package root.entities.plants;

import root.entities.stuffs.FreezePea;
import root.entities.stuffs.Stuff;
import root.entities.zombies.Zombie;

import java.awt.*;

public class FreezePeaShooter extends PeaShooter {

  public FreezePeaShooter(int x, int y) {
    super(x, y);
    price = 175;
    health = 200;
  }

  @Override
  public void dealWithZom() {
    Zombie closestZom = closestZom(zomOnLane());
    for (Stuff stuff : stuffs) {
      if (closestZom.getX() - stuff.getX() < closestZom.getImage().getWidth(null) / 4) {
        ((FreezePea) stuff).hitted = true;
        closestZom.stunt = true;
        closestZom.health -= 15;
      }
    }
  }

  @Override
  public void shoot() {
    stuffs.add(new FreezePea(position.x + stuffShooter.x, position.y + stuffShooter.y));
  }

  @Override
  public Image getImage() {
    return visualMode.FreezePeaShooterImage;
  }
}
