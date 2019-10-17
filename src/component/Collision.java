package component;

import entity.Entity;

public class Collision extends Component {
    /* Method settings for checkCollision */
    private boolean edge_collision = false;

    public Collision() {
        super();
    }

    public void edge_collision(boolean edge_collision) {
        this.edge_collision = edge_collision;
    }

    public boolean checkCollision(Entity e) {
        var pC1 = this.owner().get(Position.class);
        var pC2 = e.get(Position.class);
        var sC1 = this.owner().get(Size.class);
        var sC2 = e.get(Size.class);

        var edge_collision =
                this.edge_collision | e.get(Collision.class).edge_collision;

        boolean is_collision;
        if (edge_collision)
            is_collision = pC1.x() <= pC2.x() + sC2.width() &&
                    pC1.x() + sC1.width() >= pC2.x() &&
                    pC1.y() <= pC2.y() + sC2.height() &&
                    pC1.y() + sC1.height() >= pC2.y();
        else
            is_collision = pC1.x() < pC2.x() + sC2.width() &&
                    pC1.x() + sC1.width() > pC2.x() &&
                    pC1.y() < pC2.y() + sC2.height() &&
                    pC1.y() + sC1.height() > pC2.y();
        return is_collision;
    }

}

