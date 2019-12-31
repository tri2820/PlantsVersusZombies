package root.entities.plants;

import java.awt.Image;

public class Walnut extends Plant {

    public Walnut(int x, int y) {
        super(x, y);
        price = 50;
        health = 500;
    }

    @Override
    public Image getImage() {
        if (health >= 300) {
            return visualMode.Walnut1;
        } else if (health >= 100) {
            return visualMode.Walnut2;
        } else {
            return visualMode.Walnut3;
        }
    }

    @Override
    public int adjustX() {
        return 10;
    }


    @Override
    public void actions() {
        //unable to fix now
    }
}
