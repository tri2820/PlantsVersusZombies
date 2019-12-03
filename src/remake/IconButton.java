package remake;

import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IconButton extends JButton {

  IconButton(ImageIcon ii, int x, int y, MouseListener ml) {
    setIcon(ii);
    setOpaque(false);
    setContentAreaFilled(false);
    setBorderPainted(false);
    setVisible(true);
    setBounds(x, y, ii.getIconWidth(), ii.getIconHeight());
    addMouseListener(ml);
  }
}
