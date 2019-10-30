package entity;

import component.Collision;
import component.Health;
import component.Position;
import component.Size;

import java.util.ArrayList;
import java.util.List;

public class Zombie extends Entity {
    public Zombie() {
        this.addComponent(new Collision(
                new ArrayList<>(List.of(Zombie.class))
        ));

        this.addComponent(new Position(0, 0));
        this.addComponent(new Size(10, 10));
        this.addComponent(new Health(50, -7));
    }

    public Zombie(int x, int y) {
        this();
        this.removeComponent(Position.class);
        this.addComponent(new Position(x, y));
    }
}


