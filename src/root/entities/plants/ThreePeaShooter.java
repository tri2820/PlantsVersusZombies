package root.entities.plants;

import java.awt.Image;

public class ThreePeaShooter extends PeaShooter {

    public ThreePeaShooter(int x, int y) {
        super(x, y);
        price = 375;
        health = 200;
    }

    @Override
    public int adjustX() {
        return -10;
    }

    @Override
    public int adjustY() {
        return -20;
    }

    @Override
    public Image getImage() {
        return visualMode.ThreePeaShooterImage;
    }
}
