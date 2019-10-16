package Components;

import Systems.Component;
import Systems.Entity;

public class Collision extends Component {
    public boolean edge_collision = false;

    public Collision() {
        super();
    }

    public boolean checkCollision(Entity e) {
        // Get Position and Size of entities as requirements
        var pC1 = this.getEntity().getComponent(Position.class);
        var pC2 = e.getComponent(Position.class);
        var sC1 = this.getEntity().getComponent(Size.class);
        var sC2 = e.getComponent(Size.class);
        var edge_collision =
                this.edge_collision | e.getComponent(Collision.class).edge_collision;

        boolean is_collision;
        if (edge_collision)
            is_collision = pC1.x <= pC2.x + sC2.w &&
                    pC1.x + sC1.w >= pC2.x &&
                    pC1.y <= pC2.y + sC2.h &&
                    pC1.y + sC1.h >= pC2.y;
        else
            is_collision = pC1.x < pC2.x + sC2.w &&
                    pC1.x + sC1.w > pC2.x &&
                    pC1.y < pC2.y + sC2.h &&
                    pC1.y + sC1.h > pC2.y;
        return is_collision;
    }
}