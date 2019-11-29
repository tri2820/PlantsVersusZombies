package Test;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ScreenSize {

  // java - get screen size using the Toolkit class
  private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

  public static void main(String[] args) {
    System.out.println(screenSize.width);
    System.out.println(screenSize.height);
  }
}
