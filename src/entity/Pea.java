package entity;

import component.*;

import java.util.ArrayList;
import java.util.List;

public class Pea extends Entity implements Move {
    private String sprite_path;

    /*
     * Initialize with sprite folder path given
     */
    public Pea(String sprite_path) {
        this.sprite_path = sprite_path;

        this.addComponent(new Collision(new ArrayList<>(List.of(Zombie.class))));
        this.addComponent(new Size(10, 10));
        this.addComponent(new Position(0, 0));
    }

    /*
     * Initialize a bullet with a given position
     * This is used to initialize the bullet when it is first spawn from a Plant
     */
    public Pea(String sprite_path, int x, int y) {
        this(sprite_path);
        this.removeComponent(Position.class);
        this.addComponent(new Position(x, y));
    }

    //move by increasing x, assume that the map x-coordinate is numbered from left to right,
    //y-coordinate is number from bottom to top
    public void move() {
        Position pos = this.getSingleComponent(Position.class);
        pos.setX(pos.getX() + 1);
    }

    public void render() {
    }
}
