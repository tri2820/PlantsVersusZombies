package entity;

import component.Collision;
import component.Health;
import component.Position;
import component.Size;

public class Zombie extends Entity {
    public Zombie() {
        this.add(new Position(0, 0));
        this.add(new Size());
        this.add(new Collision());
        this.add(new Health(50, -7));
    }

    public Zombie(int x, int y, int width, int height, int health, int on_collision_health_change) {
        this.add(new Position(x, y));
        this.add(new Size(width, height));
        this.add(new Collision());
        this.add(new Health(health, on_collision_health_change));
    }
}


