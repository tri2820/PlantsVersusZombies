package components.Base;

import entities.Base.Entity;

public class Component {

  private Entity owner;

  public <T extends Entity> T getOwner() {
    return (T) owner;
  }

  public <T extends Entity> void setOwner(T entity) {
    this.owner = entity;
  }
}