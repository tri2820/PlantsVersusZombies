package component;

public class Position extends Component {
    private int x = 0;
    private int y = 0;

    public Position() {
        super();
    }

    public Position(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    //  The 2 following methods are not really clear and set to be modified
//  The main idea are to compare the position of entities
    public boolean compareTo(Position e) {
        if (this.x < e.x) return true;
        return this.x == e.x && this.y < e.y;
    }

    public int compare(Position p) {
        if (this.getX() == p.getX()) {
            return this.getY() - p.getY();
        } else return this.getX() - p.getX();
    }
}

