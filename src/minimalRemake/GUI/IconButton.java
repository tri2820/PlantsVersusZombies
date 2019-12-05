package minimalRemake.GUI;

import java.awt.Image;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IconButton extends JButton {

  public boolean dragged = false;
  public boolean clicked = false;
  public Image dragTarget = null;

  IconButton(ImageIcon ii, int x, int y, Image dragTarget, MouseListener ml) {
    setIcon(ii);
    setOpaque(false);
    setContentAreaFilled(false);
    setBorderPainted(false);
    setVisible(true);
    setBounds(x, y, ii.getIconWidth(), ii.getIconHeight());
    addMouseListener(ml);
    this.dragTarget = dragTarget;
  }
}
