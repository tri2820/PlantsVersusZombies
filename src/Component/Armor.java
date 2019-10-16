package Component;

import Manager.Component;

public class Armor extends Component {
    int armor = 0;

    public Armor(int armor) {
        this.armor = armor;
    }

    public int get() {
        return armor;
    }

    public void set(int armor) {
        this.armor = armor;
    }

    public void change(int amount) {
        this.armor += amount;
    }
}
