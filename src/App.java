public class App {
    public static void main(String[] args) {
        /* Example where we create a system,put in a Zombie
        and check for collision between it and itself */

        /* Use a test systema, check file Systema_Test to see implementation */
        var SingletonSystem = new Systema_Test();
        /* Use class Zombie, check file Entities to see implementation */
        var Zombie = new Zombie();
        SingletonSystem.addEntity(Zombie);

        System.out.println("Example: check " + Zombie + " collision with itself");
        System.out.println("-with edge_detection=false");
        SingletonSystem.iterate();
        System.out.println("-with edge_detection=true");
        Zombie.getComponent(CollisionComponent.class).edge_collision = true;
        SingletonSystem.iterate();
    }
}
