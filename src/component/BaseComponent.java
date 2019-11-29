package component;

import entity.RootEntity;

public class BaseComponent {

  private RootEntity owner;

  public <T extends RootEntity> T getOwner() {
    return (T) owner;
  }

  public <T extends RootEntity> void setOwner(T entity) {
    this.owner = entity;
  }
}