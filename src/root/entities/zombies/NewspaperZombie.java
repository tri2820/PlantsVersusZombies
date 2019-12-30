package root.entities.zombies;

import java.awt.*;

public class NewspaperZombie extends Zombie {

    public NewspaperZombie (int x, int y) {
        super(x, y);
        health = 350;
    }

    @Override
    public Image getImage() {
        if (collided) {
            if (health >= 250) return visualMode.NewspaperZombieEatImage;
            else if (health >= 150) return visualMode.NewsZombieEatImage;
            else return visualMode.NewsZombieLostHeadEatImage;
        } else {
            if (health >= 250) return visualMode.NewspaperZombieImage;
            else if (health >= 60) return visualMode.NewsZombieImage;
            else return visualMode.NewsZombieLostHeadImage;
        }    }
}
