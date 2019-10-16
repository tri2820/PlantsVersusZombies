package Component;

import Manager.Component;

public class Health extends Component {
    int health = 100;

    public Health(int Health) {
        this.health = Health;
    }

    public int get() {
        return health;
    }

    public void set(int health) {
        this.health = health;
    }

    public void change(int amount) {
        this.health += amount;
    }
}
