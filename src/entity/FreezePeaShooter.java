package entity;

import component.Position;
import component.Shoot;

import java.io.PipedOutputStream;

public class FreezePeaShooter extends Plant implements Shoot {

    public FreezePeaShooter(int x, int y, int health) {
        super(x, y, health);
    }

    @Override
    public Pea shoot() {
        Position pos = this.getSingleComponent(Position.class);
        FreezePea pea = new FreezePea(pos.getX(), pos.getY(), 1, 7);
        return pea;
    }
}
