class Systema_Test extends Systema {
  Systema_Test() {
    super();
  }

  @Override
  void iterate() {

    boolean collision = false;

    /* For each entity */
    for (var e : this.entities) {
      /* Do something with CollisionComponent */
      if (e.hasComponent(CollisionComponent.class)) {
        /* Check collision of e with itself */
        collision = e.getComponent(CollisionComponent.class).checkCollision(e);
        System.out.println("Systema check collision=" + collision);
      }

      /* Do something else with HealthComponent */
      if (e.hasComponent(HealthComponent.class)) {
        if (collision) {
          System.out.println("Systema calls reduceHealth with event=`collision`");
          e.getComponent(HealthComponent.class).reduceHealth("collision");
        }
      }

      /* Do something else with other components */
    }
  }
}
