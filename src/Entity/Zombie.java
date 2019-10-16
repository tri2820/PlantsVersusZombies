package Entity;

import Component.Condition.EdgeCollidable;
import Component.Health;
import Component.Position;
import Component.Size;
import Manager.Entity;

public class Zombie extends Entity {
    public Zombie() {
        this.addComponent(Position.class);
        this.addComponent(Size.class);
        this.addComponent(EdgeCollidable.class);

        this.addComponent(Health.class);
        this.getComponent(Health.class).set(50);
    }
}