package root.entities.zombies;

import java.awt.*;

public class BucketHeadZombie extends Zombie {
    public BucketHeadZombie(int x, int y) {
        super(x, y);
        health = 350;
    }

    @Override
    public Image getImage() {
        if (collided) {
            if (health >= 150) return visualMode.BucketHeadZombieEatImage;
            else if (health >= 60) return visualMode.NormalZombieEatImage;
            else return visualMode.NormalZombieLostHeadEatImage;
        } else {
            if (health >= 150) return visualMode.BucketHeadZombieWalkImage;
            else if (health >= 60) return visualMode.NormalZombieWalkImage;
            else return visualMode.NormalZombieLostHeadWalkImage;
        }
    }
}
