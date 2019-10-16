package Component;

import Manager.Component;

public class Health extends Component {
    public int health = 100;
    public int on_collision_reduce_health = 5;

    public Health() {
        super();
    }

    public void reduceHealth(String event) {
        if (event == "collision") this.health -= this.on_collision_reduce_health;
    }
}
