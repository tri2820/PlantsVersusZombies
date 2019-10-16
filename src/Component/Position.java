package Component;

import Manager.Component;

public class Position extends Component {
    int x = 0;
    int y = 0;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void changeX(int amount) {
        x += amount;
    }

    public void changeY(int amount) {
        y += amount;
    }
}
