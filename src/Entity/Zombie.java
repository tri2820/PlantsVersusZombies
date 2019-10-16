package Entity;

import Component.EdgedCollide;
import Component.Health;
import Component.Position;
import Component.Size;
import Manager.Entity;

public class Zombie extends Entity {
    public Zombie() {
        this.addComponent(Position.class);
        this.addComponent(Size.class);
        this.addComponent(EdgedCollide.class);

        this.addComponent(Health.class);
        this.getComponent(Health.class).health = 50;
        this.getComponent(Health.class).on_collision_reduce_health = 7;
    }
}