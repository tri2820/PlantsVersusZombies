package Component;

import Manager.Component;

class Damage extends Component {
    int damage = 1;

    public Damage(int damage) {
        this.damage = damage;
    }

    public int get() {
        return damage;
    }

    public void set(int Damage) {
        this.damage = Damage;
    }

    public void change(int amount) {
        this.damage += amount;
    }
}
