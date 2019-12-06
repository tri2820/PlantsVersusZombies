package PvZ;

import PvZ.Base.Commons;

public class Test {

  public static void main(String[] args) {
    System.out.println(Commons.BackgroundImage);
    Commons.initAll();
    System.out.println(Commons.BackgroundImage.getHeight(null));
  }
}
