package root.entities.plants;

import java.awt.Image;
import root.entities.stuffs.FreezePea;
import root.entities.stuffs.Stuff;
import root.entities.zombies.Zombie;

public class FreezePeaShooter extends PeaShooter {

  public FreezePeaShooter(int x, int y) {
    super(x, y);
    price = 175;
    health = 150;
  }

  @Override
  public void dealWithZom() {
    Zombie closestZom = closestZom(zomOnLane());
    for (Stuff stuff : stuffs) {
      if (closestZom.getX() - stuff.getX() < closestZom.getImage().getWidth(null) / 4) {
        ((FreezePea) stuff).hitted = true;
        closestZom.stunt = true;
        closestZom.health -= 12;
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
