package Entities;

import Components.Collision;
import Components.Health;
import Components.Position;
import Components.Size;
import Systems.Entity;

public class Zombie extends Entity {
    public Zombie() {
        this.addComponent(Position.class);
        this.addComponent(Size.class);
        this.addComponent(Collision.class);

        this.addComponent(Health.class);
        this.getComponent(Health.class).health = 50;
        this.getComponent(Health.class).on_collision_reduce_health = 7;
    }
}