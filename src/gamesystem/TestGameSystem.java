package gamesystem;

import component.Health;
import component.Position;
import entity.Entity;

import java.util.ArrayList;


public class TestGameSystem extends GameSystem {
    private static TestGameSystem test_game_system = null;

    private TestGameSystem() {
        super();
    }

    static public TestGameSystem getSingleton() {
        if (test_game_system == null) test_game_system = new TestGameSystem();
        return test_game_system;
    }

    @Override
    public void step() {
        this.elapsed_step++;
        var collisions = TestSystemUtils.getCollisions(this.entities());
        TestSystemUtils.reduceHealthOnCollision(collisions, true);
    }
}


class TestSystemUtils {
    /* Return list of lists of entities */
    /* Entities in a list collide with each other */
    public static <T extends Entity> ArrayList<ArrayList<T>> getCollisions(ArrayList<T> entities) {
        var result = new ArrayList<ArrayList<T>>();
        entities.sort((e1, e2) -> e1.get(Position.class).compare(e2.get(Position.class)));

        for (int i = 0; i < entities.size(); ) {
            int j = i;
            Position pi = entities.get(i).get(Position.class);
            /* [i,j) will be the range of collision */
            while (j < entities.size() && entities.get(j).get(Position.class).compare(pi) == 0) j++;
            /* A collision needs 2 or more entities */
            if (j - i >= 2) {
                var same_position_entities = new ArrayList<>(entities.subList(i, j));
                result.add(same_position_entities);
            }
            i = j;
        }
        return result;
    }


    /* Receive a list of *lists of entities */
    /* For each *list, for each entity, emit ReduceHealthEvent due to collision */
    public static <T extends Entity> void reduceHealthOnCollision(ArrayList<ArrayList<T>> collisions, boolean collision_once) {
        for (var collision : collisions)
            for (var e : collision)
                if (collision_once)
                    e.get(Health.class).changeHealth(Health.Event.OnCollision);
                else
                    /* entity e will collide n times, n is the number of all other entities in that collision*/
                    for (int i = 1; i < collision.size(); i++)
                        e.get(Health.class).changeHealth(Health.Event.OnCollision);
    }
}