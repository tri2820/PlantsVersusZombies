import component.Health;
import entity.Zombie;
import gamesystem.TestGameSystem;
import java.util.stream.Collectors;
import javax.swing.JPanel;

public class App {

  public static JPanel jpanel = new JPanel();

  public static void main(String[] args) {
    /* Create windows, etc */

    var game = TestGameSystem.getSingleton();

    var z0 = new Zombie(""); //need add sprite, wait for Cuong, he will find someway to fix it
    var z1 = new Zombie("", 1, 1);
    var z2 = new Zombie("", 3, 2);
    game.add(z0);
    game.add(z1);
    game.add(z2);

    game.init();

    while (
        game.entities().stream().map(entity -> entity.getSingleComponent(Health.class).getHealth())
            .mapToInt(Integer::intValue).sum() > 0) {
      System.out.println(game.entities().stream()
          .map(entity -> entity.getSingleComponent(Health.class).getHealth())
          .collect(Collectors.toList()));
      game.step();
    }

    System.out.println("It took " + game.elapsedTime() + " milliseconds and "
        + game.elapsedStep() + " game steps for all zombies to die due to collision");

  }
}
