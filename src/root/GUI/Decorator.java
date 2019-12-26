package root.GUI;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.event.MouseInputListener;

public class Decorator extends JButton {

  public boolean dragged = false;
  public boolean clicked = false;
  public Image dragTarget;

  public Decorator(
      ImageIcon ii, int x, int y, Image dragTarget, MouseInputListener mouseInputListener) {
    setIcon(ii);
    setOpaque(false);
    setContentAreaFilled(false);
    setBorderPainted(false);
    setVisible(true);
    setBounds(x, y, ii.getIconWidth(), ii.getIconHeight());
    addMouseListener(mouseInputListener);
    addMouseMotionListener(mouseInputListener);
    this.dragTarget = dragTarget;
  }
}
