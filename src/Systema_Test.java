class Systema_Test extends Systema {
    Systema_Test() {
        super();
    }

    @Override
    void iterate() {

        /* For each entity */
        for (var e : this.entities) {
            /* Do something with CollisionComponent */
            if (e.hasComponent(CollisionComponent.class)) {
                /* Check collision of e with itself */
                var collision = CollisionComponent.checkCollision(e, e);
                System.out.println(collision);
            }

            /* Do something else with other components */
        }

    }
}
