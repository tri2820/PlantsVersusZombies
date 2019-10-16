package Component;

import Manager.Component;

public class Size extends Component {
    int w = 0;
    int h = 0;

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Size(int w, int h) {
        this.w = w;
        this.h = h;
    }

    public void changeW(int amount) {
        w += amount;
    }

    public void changeH(int amount) {
        h += amount;
    }
}
