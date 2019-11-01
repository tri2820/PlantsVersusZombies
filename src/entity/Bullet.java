package entity;

import component.Collision;
import component.Position;
import component.Size;

import java.util.ArrayList;
import java.util.List;

public class Bullet extends Entity {
    private String sprite = "";

    /*
     * Initialize with sprite folder path given
     */
    public Bullet(String sprite) {
        this.sprite = sprite;
        this.addComponent(new Collision(new ArrayList<>(List.of(Zombie.class))));
        this.addComponent(new Size(10, 10));
        this.addComponent(new Position(0, 0));
    }

    /*
     * Initialize a bullet with a given position
     * This is used to initialize the bullet when it is first spawn from a Plant
     */
    public Bullet(String sprite, int x, int y) {
        this(sprite);
        this.removeComponent(Position.class);
        this.addComponent(new Position(x, y));
    }

    //move by increasing x, assume that the map x-coordinate is numbered from left to right,
    //y-coordinate is number from bottom to top
    public void move() {
        Position pos = this.getSingleComponent(Position.class);
        pos.setX(pos.getX() + 1);
    }
}
