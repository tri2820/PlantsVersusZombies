package root.entities.plants;

import java.awt.Image;
import root.entities.movable.HeadedSun;

public class SunShroom extends Plant {
    public SunShroom(int x, int y) {
        super(x, y);
        price = 50;
        health = 200;
        stuffShooter.x += adjustX();
        stuffShooter.y += adjustY();
    }

    @Override
    public void actions() {
        LoopCounter++;
        if (LoopCounter % 256 == 0) {
            Stuffs.add(new HeadedSun(position.x + stuffShooter.x, position.y + stuffShooter.y));
        }
    }

    @Override
    public int adjustX() {
        return 15;
    }

    @Override
    public int adjustY() {
        return 20;
    }

    @Override
    public Image getImage() {
        return visualMode.SunShroomImage;
    }
}
