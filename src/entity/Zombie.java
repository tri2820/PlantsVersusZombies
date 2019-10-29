package entity;

import component.Collision;
import component.Health;
import component.Position;
import component.Size;

import java.util.ArrayList;
import java.util.List;

public class Zombie extends Entity {
    public Zombie() {
        this.add(new Collision(
                new ArrayList<>(List.of(Zombie.class))
        ));

        this.add(new Position(0, 0));
        this.add(new Size(10, 10));
        this.add(new Health(50, -7));
    }

    public Zombie(int x, int y) {
        this();
        this.remove(Position.class);
        this.add(new Position(x, y));
    }
}


