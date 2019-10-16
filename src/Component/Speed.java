package Component;

import Manager.Component;

class Speed extends Component {
    int speed = 1; // default speed, implement later in system

    public Speed(int speed) {
        this.speed = speed;
    }

    public int getS() {
        return speed;
    }

    public void set(int speed) {
        this.speed = speed;
    }

    public void change(int amount) {
        this.speed += amount;
    }
}
