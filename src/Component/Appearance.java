package Component;

import Manager.Component;

import javax.swing.*;

public class Appearance extends Component {
    String path;

    public Appearance(String path) {
        this.path = path;
    }

    // user labels as it can store GIFs
    public JLabel makeLabel(String p) {
        ImageIcon icon = new ImageIcon(p);
        JLabel label = new JLabel(icon);
        return label;
    }

    public JLabel get() {
        return makeLabel(path);
    }

    public void set(String path) {
        this.path = path;
    }
}
