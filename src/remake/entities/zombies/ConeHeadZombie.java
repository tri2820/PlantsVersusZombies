package remake.entities.zombies;

import java.awt.Image;

public class ConeHeadZombie extends Zombie {

  public ConeHeadZombie(int x, int y) {
    super(x, y);
    health = 200;
  }

  @Override
  public Image getImage() {
    return visualMode.ConeHeadZombieImage;
  }
}
