public class App {
  public static void main(String[] args) {
    /* Create windows, etc */
    /* Example where we create a system, put in a Zombie
    and check for collision between it and itself */

    /* Use a test systema, check file Systema_Test to see implementation */
    var SingletonSystem = new Systema_Test();
    /* Use class Zombie, check file Entities to see implementation */
    var zombie = new Zombie();

    SingletonSystem.addEntity(zombie);

    System.out.println("zombie has :" + zombie.getComponents());

    System.out.println("Check " + zombie + " collision with itself");
    System.out.println("-with edge_detection=false");
    SingletonSystem.iterate();
    System.out.println(
        "Zombie's health: " + zombie.getComponent(HealthComponent.class).getHealth());
    System.out.println("-with edge_detection=true");
    zombie.getComponent(CollisionComponent.class).edge_collision = true;
    SingletonSystem.iterate();
    System.out.println(
        "Zombie's health: " + zombie.getComponent(HealthComponent.class).getHealth());
  }
}
