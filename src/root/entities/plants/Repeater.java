package root.entities.plants;

import root.entities.moveable.Pea;
import root.entities.moveable.MoveableObjects;
import root.entities.zombies.Zombie;

import java.awt.*;

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
        for (MoveableObjects moveableObjects : listZombies) {
            if (closestZom.getX() - moveableObjects.getX() < closestZom.getImage().getWidth(null) / 4) {
                ((Pea) moveableObjects).hitted = true;
                closestZom.health -= 30;
            }
        }
    }

    @Override
    public void shoot() {
        listZombies.add(new Pea(position.x + stuffShooter.x, position.y + stuffShooter.y));
        listZombies.add(new Pea(position.x + stuffShooter.x + 40, position.y + stuffShooter.y));
    }
}
