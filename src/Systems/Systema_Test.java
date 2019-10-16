package Systems;

import Components.Collision;
import Components.Health;

public class Systema_Test extends Systema {
    public Systema_Test() {
        super();
    }

    @Override
    public void iterate() {

        boolean collision = false;

        /* For each entity */
        for (var e : this.entities) {
            /* Do something with CollisionComponent */
            if (e.hasComponent(Collision.class)) {
                /* Check collision of e with itself */
                collision = e.getComponent(Collision.class).checkCollision(e);
                System.out.println("ECS.Systema check collision=" + collision);
            }

            /* Do something else with HealthComponent */
            if (e.hasComponent(Health.class)) {
                if (collision) {
                    System.out.println("ECS.Systema calls reduceHealth with event=`collision`");
                    e.getComponent(Health.class).reduceHealth("collision");
                }
            }

            /* Do something else with other components */
        }

    }
}
