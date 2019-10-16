package Component.Condition;

import Manager.Component;

public class Resizable extends Component {
    boolean value = false;

    public boolean isValue() {
        return value;
    }

    public void set(boolean value) {
        this.value = value;
    }
}