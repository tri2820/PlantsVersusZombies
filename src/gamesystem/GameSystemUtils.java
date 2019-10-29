package gamesystem;

import component.Collision;
import component.Health;
import component.Position;
import component.Size;
import entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class GameSystemUtils {
    /* Return list of lists of entities */
    /* Entities in a list collide with each other */
    public static <T extends Entity> ArrayList<ArrayList<T>> getCollisions(ArrayList<T> entities) {
        var result = new ArrayList<ArrayList<T>>();
        for (var e : entities)
            for (var e1 : entities)
                if (checkCollision(e, e1))
                    result.add(new ArrayList<>(List.of(e, e1)));

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


    public static boolean checkCollision(Entity e, Entity e1) {
        var e_collide_e1 = e.get(Collision.class).allow(e1.getClass());
        var e1_collide_e = e1.get(Collision.class).allow(e.getClass());
        if (!(e_collide_e1 && e1_collide_e))
            return false;


        var pC1 = e1.get(Position.class);
        var pC2 = e.get(Position.class);
        var sC1 = e1.get(Size.class);
        var sC2 = e.get(Size.class);

        boolean is_collision;
        is_collision = pC1.x() < pC2.x() + sC2.width() &&
                pC1.x() + sC1.width() > pC2.x() &&
                pC1.y() < pC2.y() + sC2.height() &&
                pC1.y() + sC1.height() > pC2.y();
        return is_collision;
    }

}
