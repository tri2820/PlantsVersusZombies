package root.entities.plants;

import root.entities.PlantAttackable;
import root.entities.movable.MovableObjects;
import root.entities.movable.Pea;
import root.entities.zombies.Zombie;

import java.awt.*;

public class ThreePeaShooter extends PeaShooter {

    public ThreePeaShooter(int x, int y) {
        super(x, y);
        price = 375;
        health = 200;
    }

    @Override
    public void dealWithZom() {
        Zombie closestZom = closestZom(zomOnLane());
        for (MovableObjects movableObjects : Stuffs) {
            if (closestZom.getX() - movableObjects.getX() < closestZom.getImage().getWidth(null) / 4) {
                ((Pea) movableObjects).hitted = true;
                closestZom.health -= 15; //per pea
            }
        }
    }

    @Override
    public void shoot() {

    }

    @Override
    public Image getImage() {
        return visualMode.ThreePeaShooterImage;
    }
}
