package root.entities.plants;

import java.awt.Image;
import root.entities.movable.MovableObjects;
import root.entities.movable.Pea;
import root.entities.zombies.Zombie;

public class Repeater extends PeaShooter {

    public Repeater(int x, int y) {
        super(x, y);
        price = 200;
        health = 200;
    }

    @Override
    public Image getImage() {
        return visualMode.RepeaterImage;
    }

    @Override
    public void dealWithZom() {
        Zombie closestZom = closestZom(zomOnLane());
        for (MovableObjects movableObjects : Stuffs) {
            if (closestZom.getX() - movableObjects.getX() < closestZom.getImage().getWidth(null) / 4) {
                ((Pea) movableObjects).hitted = true;
                closestZom.health -= 30;
            }
        }
    }

    @Override
    public void shoot() {
        Stuffs.add(new Pea(position.x + stuffShooter.x, position.y + stuffShooter.y));
        Stuffs.add(new Pea(position.x + stuffShooter.x + 40, position.y + stuffShooter.y));
    }
}
