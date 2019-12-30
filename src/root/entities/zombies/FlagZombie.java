package root.entities.zombies;

import java.awt.*;

public class FlagZombie extends Zombie {

    public FlagZombie (int x, int y) {
        super(x, y);
        health = 250;
    }
    @Override
    public Image getImage() {
        if (collided) {
            if (health >= 60) return visualMode.FlagZombieEatImage;
            else return visualMode.FlagZombieLostHeadEatImage;
        } else {
            if (health >= 60) return visualMode.FlagZombieImage;
            else return visualMode.FlagZombieLostHeadImage;
        }    }
}
