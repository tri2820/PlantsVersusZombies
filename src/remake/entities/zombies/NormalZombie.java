package remake.entities.zombies;

import java.awt.Image;

public class NormalZombie extends Zombie {

  public NormalZombie(int x, int y) {
    super(x, y);
    health = 100;
  }


  @Override
  public Image getImage() {
    return visualMode.NormalZombieImage;
  }
}
