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

    boolean checkCollision(Entity e) {
        // Get PositionComponent and SizeComponent of entities as requirements
        var pC1 = this.getEntity().getComponent(PositionComponent.class);
        var pC2 = e.getComponent(PositionComponent.class);
        var sC1 = this.getEntity().getComponent(SizeComponent.class);
        var sC2 = e.getComponent(SizeComponent.class);
        var edge_collision =
                this.edge_collision | e.getComponent(CollisionComponent.class).edge_collision;

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


class HealthComponent extends Component {
    public int health = 100;
    public int on_collision_reduce_health = 5;

    public HealthComponent() {
        super();
    }

    void reduceHealth(String event) {
        if (event == "collision") this.health -= this.on_collision_reduce_health;
    }
}

class Speed extends Component {
    // step define the delay time between each behavior of an entity
    public int step = 10;
    // amount of time added or subtracted on special events
    public int step_change = 1;

    public Speed() {
        super();
    }

    void SpeedUp(String event) {
        if (event == "fasten")
            this.step -= step_change;//less delay -> faster
    }

    void SpeedDown(String event) {
        if (event == "slowed")
            this.step += step_change;//more delay -> longer
    }
}

class Damage extends Component {
    public Damage() {
        super();
    }
    public int dmg = 1;
    public int dmg_change = 1;
    void SpeedUp(String event) {
        if (event == "powered")
            this.dmg -= dmg_change;//less delay -> faster
    }

    void SpeedDown(String event) {
        if (event == "weaken")
            this.dmg += dmg_change;//more delay -> longer
    }
}

