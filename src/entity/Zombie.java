package entity;

import component.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Zombie extends Entity implements Move {
    private int speed;
    private String sprite_path;

    /*
     * Initialize with sprite folder path given
     */
    public Zombie(String sprite_path) {
        this.sprite_path = sprite_path;

        this.addComponent(new Collision(
                new ArrayList<>(List.of(Zombie.class, Plant.class, Pea.class))
        ));

        this.addComponent(new Position(0, 0));
        this.addComponent(new Size(10, 10));
        this.addComponent(new Health(50, -7));
    }

    /*
     * Initialize a bullet with a given position
     * This is used to initialize the bullet when it is first spawn from a Plant
     */
    public Zombie(String sprite_path, int x, int y) {
        this(sprite_path);
        this.removeComponent(Position.class);
        this.addComponent(new Position(x, y));
    }

    //move by decreasing x, assume that the map x-coordinate is numbered from left to right,
    //y-coordinate is number from bottom to top
    public void move() {
        Position pos = getSingleComponent(Position.class);
        pos.setX(pos.getX() - speed);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}


