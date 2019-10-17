import component.Health;
import entity.Zombie;
import gamesystem.TestGameSystem;

import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        /* Create windows, etc */

        var game = TestGameSystem.getSingleton();

        var z0 = new Zombie();
        var z1 = new Zombie(0, 0, 0, 0, 30, -3);
        var z2 = new Zombie(0, 0, 0, 0, 30, -5);
        game.add(z0);
        game.add(z1);
        game.add(z2);

        game.init();

        while (game.entities().stream().map(entity -> entity.get(Health.class).health()).mapToInt(Integer::intValue).sum() > 0) {
            System.out.println(game.entities().stream().map(entity -> entity.get(Health.class).health()).collect(Collectors.toList()));
            game.step();
        }

        System.out.println("It took " + game.elapsedTime() + " milliseconds and "
                + game.elapsedStep() + " game steps for all zombies to die due to collision");

    }
}
