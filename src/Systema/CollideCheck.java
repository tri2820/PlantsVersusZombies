package Systema;

import Component.Condition.EdgeCollidable;
import Component.Position;
import Component.Size;
import Manager.Entity;
import Manager.Systema;

public class CollideCheck extends Systema {
    public boolean result(Entity a, Entity b) {
        // Get Position and Size of entities as requirements
        var pC1 = a.getComponent(Position.class);
        var pC2 = b.getComponent(Position.class);
        var sC1 = a.getComponent(Size.class);
        var sC2 = b.getComponent(Size.class);
        var edge_collision = a.getComponent(EdgeCollidable.class).isValue()
                | b.getComponent(EdgeCollidable.class).isValue();

        boolean is_collision;
        if (edge_collision)
            is_collision = pC1.getX() <= pC2.getX() + sC2.getW() &&
                    pC1.getX() + sC1.getW() >= pC2.getX() &&
                    pC1.getY() <= pC2.getY() + sC2.getH() &&
                    pC1.getY() + sC1.getH() >= pC2.getY();
        else
            is_collision = pC1.getX() < pC2.getX() + sC2.getW() &&
                    pC1.getX() + sC1.getW() > pC2.getX() &&
                    pC1.getY() < pC2.getY() + sC2.getH() &&
                    pC1.getY() + sC1.getH() > pC2.getY();
        return is_collision;
    }
}