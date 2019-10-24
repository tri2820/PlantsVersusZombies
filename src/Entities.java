class Zombie extends Entity {
    Zombie() {
        this.addComponent(PositionComponent.class);
        this.addComponent(SizeComponent.class);
        this.addComponent(CollisionComponent.class);

        this.addComponent(HealthComponent.class);
        this.getComponent(HealthComponent.class).setHealth(50);
        this.getComponent(HealthComponent.class).setOn_collision_reduce_health(7);

        this.addComponent(SpeedComponent.class);

        this.addComponent(DamageComponent.class);
    }
}

class Plant extends Entity {
    Plant() {
        this.addComponent(PositionComponent.class);
        this.addComponent(SizeComponent.class);
        this.addComponent(CollisionComponent.class);

        this.addComponent(HealthComponent.class);
        this.getComponent(HealthComponent.class).setHealth(50);
        this.getComponent(HealthComponent.class).setOn_collision_reduce_health(7);

        this.addComponent(SpeedComponent.class);

        this.addComponent(DamageComponent.class);
    }
}

class Food extends Entity {
    Food() {
        this.addComponent(PositionComponent.class);
    }
}

class Map extends Entity { //need to be implemented
    Map() {
    }
}