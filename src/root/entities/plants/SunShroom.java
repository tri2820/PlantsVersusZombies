package root.entities.plants;

import root.entities.movable.HeadedSun;

import java.awt.*;

public class SunShroom extends Plant {
    public SunShroom(int x, int y) {
        super(x, y);
        price = 50;
        health = 200;
    }

    @Override
    public void actions() {
        LoopCounter++;
        if (LoopCounter % 256 == 0) {
            Stuffs.add(new HeadedSun(position.x + stuffShooter.x, position.y + stuffShooter.y));
        }
    }

    @Override
    public Image getImage() {
        return visualMode.SunShroomImage;
    }
}
