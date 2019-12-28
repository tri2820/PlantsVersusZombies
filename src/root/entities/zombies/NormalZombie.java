package root.entities.zombies;

import java.awt.Image;

public class NormalZombie extends Zombie {

  public NormalZombie(int x, int y) {
    super(x, y);
    health = 150;
  }


  @Override
  public Image getImage() {
    if (collided) {
      if (health >= 60) return visualMode.NormalZombieEatImage;
      else return visualMode.NormalZombieLostHeadEatImage;
    } else {
      if (health >= 60) return visualMode.NormalZombieWalkImage;
      else return visualMode.NormalZombieLostHeadWalkImage;
    }
  }
}
