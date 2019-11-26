/* Component consists of data and method
 * which evolves in an aspect of an entity*/

/* Methods could mutate the data in that component */

/* Methods should be called from a Systema (with events)
 * or other methods inside the component*/

/* Method should be as generic as possible */

/* Data should contains the state of entity in that aspect
 * or how a particular method performs */

/* Data should be assigned when create a child class of Entity (new entity type) */

/* Component could query other components as requirements */

class Component {
  private Entity parentEntity;

  public <T extends Entity> T getEntity() {
    return (T) parentEntity;
  }

  public <T extends Entity> void setEntity(T entity) {
    this.parentEntity = entity;
  }
}
