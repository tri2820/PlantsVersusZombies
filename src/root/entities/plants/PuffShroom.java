package root.entities.plants;

import root.entities.PlantAttackable;
import root.entities.movable.MovableObjects;
import root.entities.movable.Mushroom;
import root.entities.movable.Snow;
import root.entities.zombies.Zombie;

import java.awt.*;

public class PuffShroom extends PeaShooter implements PlantAttackable {
    public PuffShroom(int x, int y) {
        super(x, y);
        price = 0;
        health = 200;
    }

    @Override
    public void dealWithZom() {
        Zombie closestZom = closestZom(zomOnLane());
        for (MovableObjects movableObjects : Stuffs) {
            if (closestZom.getX() - movableObjects.getX() < closestZom.getImage().getWidth(null) / 4) {
                ((Mushroom) movableObjects).hitted = true;
                closestZom.health -= 15;
            }
        }
    }

    @Override
    public void shoot() {
        Stuffs.add(new Mushroom(position.x + stuffShooter.x, position.y + stuffShooter.y));
    }

    @Override
    public Image getImage() {
        return visualMode.PuffShroomImage;
    }
}
