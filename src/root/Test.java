package root;

import java.util.Random;
import root.GameMode.Levels.Level;

public class Test {

  public static void main(String[] args) {
    System.out.println(Level.rounds);
    while (true) {
      System.out.println(new Random().nextInt(5 - 1) + 1);
    }
  }
}
