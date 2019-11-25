package entity;

import component.*;

import java.util.ArrayList;
import java.util.List;

///Not all plants move => plant base class will not implement Move interface
public abstract class Plant extends Entity {
    /*
     * Initialize a bullet with a given position
     * This is used to initialize the bullet when it is first spawn from a Plant
     */
    public Plant(int x, int y, int health) {
        this.addComponent(new Position(x, y));
        this.addComponent(new Collision(new ArrayList<>(List.of(Zombie.class))));
        this.addComponent(new Size(10, 10));
        this.addComponent(new Health(health));
    }
}
