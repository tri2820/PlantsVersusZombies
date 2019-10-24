class PositionComponent extends Component {
    int y = 0;
    int x = 0;

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
    private int health = 100;
    private int on_collision_reduce_health = 5;

    public HealthComponent() {
        super();
    }

    void reduceHealth(String event) {
        if (event.equals("collision"))
            this.health -= this.on_collision_reduce_health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setOn_collision_reduce_health(int on_collision_reduce_health) {
        this.on_collision_reduce_health = on_collision_reduce_health;
    }

    public int getOn_collision_reduce_health() {
        return on_collision_reduce_health;
    }
}

class SpeedComponent extends Component {
    // step define the delay time between each behavior of an entity
    private int step = 10;
    // amount of time added or subtracted on special events
    private int step_change = 1;

    public SpeedComponent() {
        super();
    }

    void SpeedUp(String event) {
        if (event.equals("fasten"))
            this.step -= step_change;//less delay -> faster
    }

    void SpeedDown(String event) {
        if (event.equals("slowed"))
            this.step += step_change;//more delay -> longer
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getStep_change() {
        return step_change;
    }

    public void setStep_change(int step_change) {
        this.step_change = step_change;
    }
}

class DamageComponent extends Component {
    private int damage = 1;
    private int damage_change = 1;

    public DamageComponent() {
        super();
    }

    void SpeedUp(String event) {
        if (event.equals("powered"))
            this.damage -= this.damage_change;//less delay -> faster
    }

    void SpeedDown(String event) {
        if (event.equals("weaken"))
            this.damage += this.damage_change;//more delay -> longer
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage_change() {
        return damage_change;
    }

    public void setDamage_change(int damage_change) {
        this.damage_change = damage_change;
    }
}

