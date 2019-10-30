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

    public int x() {
        return this.x;
    }

    public void x(int x) {
        this.x = x;
    }

    public int y() {
        return this.y;
    }

    public void y(int y) {
        this.y = y;
    }

//   The following methods are to be removed

//    public boolean compareTo(Position e) {
//        if (this.x < e.x) return true;
//        return this.x == e.x && this.y < e.y;
//    }
//
//    public int compare(Position p) {
//        if (this.x() == p.x()) {
//            return this.y() - p.y();
//        } else return this.x() - p.x();
//    }
}
