class Zombie extends Entity {
    Zombie() {
        this.addComponent(PositionComponent.class);
        this.addComponent(SizeComponent.class);
        this.addComponent(CollisionComponent.class);
    }
}


