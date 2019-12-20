package root.entities.zombies;

import java.awt.*;

public class ConeHeadZombie extends Zombie {

  public ConeHeadZombie(int x, int y) {
    super(x, y);
    health = 200;
  }

  @Override
  public Image getImage() {
    if (health >= 100) {
      return visualMode.ConeHeadZombieImage;
    } else if (health >= 50) {
      return visualMode.NormalZombieImage;
    } else {
      return visualMode.HeadlessZombieImage;
    }
  }
}
