package Components;

import Systems.Component;

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
