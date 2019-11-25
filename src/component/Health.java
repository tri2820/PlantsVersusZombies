package component;

public class Health extends Component {
    /* Data */
    private int health = 100;

    public Health() {
        super();
    }

    public Health(int health) {
        super();
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    /*
     * when damaged by enemies, change health by a value,
     * it should be negative
     */
    public void reduceHealthOnDamaged(int on_collision_health_change) {
        this.health += on_collision_health_change;
    }
}
