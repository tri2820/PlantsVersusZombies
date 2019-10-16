package Systema;

import Component.EdgedCollide;
import Component.Position;
import Component.Size;
import Manager.Entity;
import Manager.Systema;

public class CollideCheck extends Systema {
    public CollideCheck() {
    }

    public boolean result(Entity a, Entity b) {
        // Get Position and Size of entities as requirements
        var pC1 = a.getComponent(Position.class);
        var pC2 = b.getComponent(Position.class);
        var sC1 = a.getComponent(Size.class);
        var sC2 = b.getComponent(Size.class);
        var edge_collision = a.getComponent(EdgedCollide.class).ValueIs() == true
                | b.getComponent(EdgedCollide.class).ValueIs() == true;

        boolean is_collision;
        if (edge_collision)
            is_collision = pC1.x <= pC2.x + sC2.getW() &&
                    pC1.x + sC1.getW() >= pC2.x &&
                    pC1.y <= pC2.y + sC2.getH() &&
                    pC1.y + sC1.getH() >= pC2.y;
        else
            is_collision = pC1.x < pC2.x + sC2.getW() &&
                    pC1.x + sC1.getW() > pC2.x &&
                    pC1.y < pC2.y + sC2.getH() &&
                    pC1.y + sC1.getH() > pC2.y;
        return is_collision;
    }
}