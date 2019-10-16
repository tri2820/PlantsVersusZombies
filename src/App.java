import Component.EdgedCollide;
import Component.Health;
import Entity.Zombie;
import Systema.CollideEffect;

public class App {
    public static void main(String[] args) {
        /* Create windows, etc */
        /* Example where we create a system, put in a Entities.Zombie
        and check for collision between it and itself */

        /* Use a test systema, check file ECS.Systema_Test to see implementation */
        var SingletonSystem = new CollideEffect();
        /* Use class Entities.Zombie, check file Entities to see implementation */
        var zombie = new Zombie();

        SingletonSystem.addEntity(zombie);

        System.out.println("zombie has :" + zombie.ComponentsList());

        System.out.println("Check " + zombie + " collision with itself");
        System.out.println("-with edge_detection=false");
        SingletonSystem.iterate();
        System.out.println("Entities.Zombie's health: " + zombie.getComponent(Health.class).health);
        System.out.println("-with edge_detection=true");
        zombie.getComponent(EdgedCollide.class).setValue(true);
        SingletonSystem.iterate();
        System.out.println("Entities.Zombie's health: " + zombie.getComponent(Health.class).health);
    }
}
