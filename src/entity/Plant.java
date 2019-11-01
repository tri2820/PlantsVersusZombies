package entity;

import component.Collision;
import component.Health;
import component.Position;
import component.Size;

import java.util.ArrayList;
import java.util.List;

public class Plant extends Entity {
    private String sprite = "";

    /*
     * Initialize with sprite folder path given
     */
    public Plant(String sprite) {
        this.sprite = sprite;
        this.addComponent(new Collision(new ArrayList<>(List.of(Zombie.class))));
        this.addComponent(new Position(0, 0));
        this.addComponent(new Size(10, 10));
        this.addComponent(new Health(100, -7));
    }

    /*
     * Initialize a bullet with a given position
     * This is used to initialize the bullet when it is first spawn from a Plant
     */
    public Plant(String sprite, int x, int y) {
        this(sprite);
        this.removeComponent(Position.class);
        this.addComponent(new Position(x, y));
    }
}
