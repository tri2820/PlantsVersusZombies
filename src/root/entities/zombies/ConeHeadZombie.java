package root.entities.zombies;

import java.awt.*;

public class ConeHeadZombie extends Zombie {

  public ConeHeadZombie(int x, int y) {
    super(x, y);
    health = 250;
  }

  @Override
  public Image getImage() {
    if (collided) {
      if (health >= 150) return visualMode.ConeHeadZombieEatImage;
      else if (health >= 60) return visualMode.NormalZombieEatImage;
      else return visualMode.NormalZombieLostHeadEatImage;
    } else {
      if (health >= 150) return visualMode.ConeHeadZombieWalkImage;
      else if (health >= 60) return visualMode.NormalZombieWalkImage;
      else return visualMode.NormalZombieLostHeadWalkImage;
    }
  }
}
