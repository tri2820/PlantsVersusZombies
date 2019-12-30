package root.entities.plants;

import java.awt.Image;

public class ThreePeaShooter extends PeaShooter {

    public ThreePeaShooter(int x, int y) {
        super(x, y);
        price = 375;
        health = 200;
    }

//    @Override
//    public void dealWithZom() {
//        Zombie closestZom = closestZom(zomOnLane());
//        for (MovableObjects movableObjects : Stuffs) {
//            if (closestZom.getX() - movableObjects.getX() < closestZom.getImage().getWidth(null) / 4) {
//                ((Pea) movableObjects).hitted = true;
//                closestZom.health -= 15; //per pea
//            }
//        }
//    }

//    @Override
//    public void shoot() {
//
//    }

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
