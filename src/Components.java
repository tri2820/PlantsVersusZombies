class PositionComponent extends Component {
    int x = 0;
    int y = 0;

    public PositionComponent() {
        super();
    }
}


class SizeComponent extends Component {
    int w = 0;
    int h = 0;

    public SizeComponent() {
        super();
    }
}


class CollisionComponent extends Component {
    boolean edge_collision = false;

    public CollisionComponent() {
        super();
    }

    static boolean checkCollision(Entity e1, Entity e2) {
        // Get PositionComponent and SizeComponent of entities as requirements
        var pC1 = e1.getComponent(PositionComponent.class);
        var pC2 = e2.getComponent(PositionComponent.class);
        var sC1 = e1.getComponent(SizeComponent.class);
        var sC2 = e2.getComponent(SizeComponent.class);
        var edge_collision =
                e1.getComponent(CollisionComponent.class).edge_collision |
                        e2.getComponent(CollisionComponent.class).edge_collision;

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

