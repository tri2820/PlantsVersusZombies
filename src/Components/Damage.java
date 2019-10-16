package Components;

import Systems.Component;

class Damage extends Component {
    public int dmg = 1;
    public int dmg_change = 1;

    public Damage() {
        super();
    }

    void SpeedUp(String event) {
        if (event == "powered")
            this.dmg -= dmg_change;//less delay -> faster
    }

    void SpeedDown(String event) {
        if (event == "weaken")
            this.dmg += dmg_change;//more delay -> longer
    }
}
