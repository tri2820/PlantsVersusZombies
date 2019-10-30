package component;

public class Health extends Component {
    /* Method settings for reduceHealth (on Collision Event) */
    private int on_collision_health_change = -5;
    /* Data */
    private int health = 100;

    public Health() {
        super();
    }

    public Health(int health, int on_collision_health_change) {
        super();
        this.health = health;
        this.on_collision_health_change = on_collision_health_change;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void changeHealth(Event e) {
        if (e == Event.OnCollision)
            this.health += this.on_collision_health_change;
    }

    public enum Event {
        OnCollision

    }

}
