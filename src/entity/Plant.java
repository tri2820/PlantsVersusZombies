package entity;

import component.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Plant extends Entity {
    private String sprite_path;

    /*
     * Initialize with sprite folder path given
     */
    public Plant(String sprite_path) {
        this.sprite_path = sprite_path;

        this.addComponent(new Collision(new ArrayList<>(List.of(Zombie.class))));
        this.addComponent(new Position(0, 0));
        this.addComponent(new Size(10, 10));
        this.addComponent(new Health(100, -7));
    }

    /*
     * Initialize a bullet with a given position
     * This is used to initialize the bullet when it is first spawn from a Plant
     */
    public Plant(String sprite_path, int x, int y) {
        this(sprite_path);
        this.removeComponent(Position.class);
        this.addComponent(new Position(x, y));
    }
}
