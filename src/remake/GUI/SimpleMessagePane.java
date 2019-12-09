package remake.GUI;

import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SimpleMessagePane extends JFrame {

  SimpleMessagePane(String message, JComponent parent) {
    JLabel label = new JLabel(message);
    label.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
    JFrame myFrame = new JFrame();
    myFrame.add(label);
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.setUndecorated(true);
    myFrame.pack();
    myFrame.setLocationRelativeTo(parent);
    myFrame.setVisible(true);
  }

  SimpleMessagePane(String message, JComponent parent, String font) {
    JLabel label = new JLabel(message);
    label.setFont(new Font(font, Font.PLAIN, 12));
    JFrame myFrame = new JFrame();
    myFrame.add(label);
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.setUndecorated(true);
    myFrame.pack();
    myFrame.setLocationRelativeTo(parent);
    myFrame.setVisible(true);
  }

  SimpleMessagePane(String message, JComponent parent, String font, int font_style) {
    JLabel label = new JLabel(message);
    label.setFont(new Font(font, font_style, 12));
    JFrame myFrame = new JFrame();
    myFrame.add(label);
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.setUndecorated(true);
    myFrame.pack();
    myFrame.setLocationRelativeTo(parent);
    myFrame.setVisible(true);
  }

  public SimpleMessagePane(String message, JComponent parent, String font, int font_style, int font_size) {
    JLabel label = new JLabel(message);
    label.setFont(new Font(font, font_style, font_size));
    JFrame myFrame = new JFrame();
    myFrame.add(label);
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.setUndecorated(true);
    myFrame.pack();
    myFrame.setLocationRelativeTo(parent);
    myFrame.setVisible(true);
  }
}
