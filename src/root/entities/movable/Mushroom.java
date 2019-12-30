package root.entities.movable;

import java.awt.*;

public class Mushroom extends Pea {
    public Mushroom(int x, int y) {
        super(x, y);
    }

    @Override
    public Image getImage() {
        return visualMode.MushroomImage;
    }
}
