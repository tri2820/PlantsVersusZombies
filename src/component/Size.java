package component;

public class Size extends Component {
    private int width = 0;
    private int height = 0;

    public Size() {
        super();
    }

    public Size(int width, int height) {
        super();
        this.width = width;
        this.height = height;
    }

    public int width() {
        return this.width;
    }

    public void width(int width) {
        this.width = width;
    }

    public int height() {
        return this.height;
    }

    public void height(int height) {
        this.height = height;
    }
}
