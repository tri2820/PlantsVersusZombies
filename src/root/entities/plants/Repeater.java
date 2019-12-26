package root.entities.plants;

import root.entities.stuffs.Pea;
import root.entities.stuffs.MoveableEntity;
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
        for (MoveableEntity moveableEntity : moveableEntities) {
            if (closestZom.getX() - moveableEntity.getX() < closestZom.getImage().getWidth(null) / 4) {
                ((Pea) moveableEntity).hitted = true;
                closestZom.health -= 30;
            }
        }
    }

    @Override
    public void shoot() {
        moveableEntities.add(new Pea(position.x + stuffShooter.x, position.y + stuffShooter.y));
        moveableEntities.add(new Pea(position.x + stuffShooter.x + 40, position.y + stuffShooter.y));
    }
}
