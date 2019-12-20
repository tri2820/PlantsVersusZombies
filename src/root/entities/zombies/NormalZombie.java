package root.entities.zombies;

import java.awt.*;

public class NormalZombie extends Zombie {

  public NormalZombie(int x, int y) {
    super(x, y);
    health = 100;
  }


  @Override
  public Image getImage() {
    if (health >= 50) {
      return visualMode.NormalZombieImage;
    } else {
      return visualMode.HeadlessZombieImage;
    }
  }
}
