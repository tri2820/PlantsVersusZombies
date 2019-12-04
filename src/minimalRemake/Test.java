package minimalRemake;

import minimalRemake.Base.Commons;

public class Test {
  public static void main(String[] args) {
    System.out.println(Commons.Background);
    Commons.init();
    System.out.println(Commons.Background.getHeight(null));
  }
}
