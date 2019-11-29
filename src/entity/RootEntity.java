package entity;

import component.BaseComponent;
import java.util.ArrayList;
import java.util.HashMap;


public abstract class RootEntity {

  private HashMap<Class, BaseComponent> components = new HashMap<>();

  /* Getter for components */
  public ArrayList<BaseComponent> getAllComponents() {
    return new ArrayList<>(components.values());
  }

  /* Check if entity is having a component of given type */
  public <T extends BaseComponent> boolean hasComponent(Class<T> component_type) {
    return components.containsKey(component_type);
  }

  /* Add component using its type*/
  public <T extends BaseComponent> void addComponent(Class<T> component_type) {
    if (hasComponent(component_type)) {
      throw new RuntimeException(
          "Cannot addComponent, " + this + " has " + component_type + " already");
    }
    var component = helper.ECS.emptyInstance(component_type);
    component.setOwner(this);
    this.components.put(component_type, component);
  }

  /* Add component using an instance*/
  public <T extends BaseComponent> void addComponent(T component) {
    if (hasComponent(component.getClass())) {
      throw new RuntimeException(
          "Cannot addComponent, " + this + " has " + component.getClass() + " already");
    }
    component.setOwner(this);
    this.components.put(component.getClass(), component);
  }

  /* Remove component by using its type */
  public <T extends BaseComponent> void removeComponent(Class<T> component_type) {
    this.components.remove(component_type);
  }

  /* Get component using its type */
  public <T extends BaseComponent> T getSingleComponent(Class<T> component_type) {
    T component = component_type.cast(this.components.get(component_type));
    if (component == null) {
      throw new RuntimeException("Cannot get component " + component_type + " from " + this);
    }
    return component;
  }
}
