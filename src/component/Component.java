package component;

import entity.Entity;

public class Component {
    private Entity owner;

    public <T extends Entity> T owner() {
        return (T) owner;
    }

    public <T extends Entity> void owner(T entity) {
        this.owner = entity;
    }
}