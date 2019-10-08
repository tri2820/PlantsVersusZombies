class Zombie extends Entity {
    Zombie() {
        this.addComponent(PositionComponent.class);
        this.addComponent(SizeComponent.class);
        this.addComponent(CollisionComponent.class);

        this.addComponent(HealthComponent.class);
        this.getComponent(HealthComponent.class).health = 50;
        this.getComponent(HealthComponent.class).on_collision_reduce_health = 7;
    }
}


