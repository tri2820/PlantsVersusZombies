package Test;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class ImageExample extends JFrame {

  public ImageExample() {

    initUI();
  }

  public static void main(String[] args) {

    EventQueue.invokeLater(() -> {
      ImageExample ex = new ImageExample();
      ex.setVisible(true);
    });
  }

  private void initUI() {

    add(new Board());

    pack();

    setTitle("Bardejov");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
  }
}