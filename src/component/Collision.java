package component;

import entity.Entity;
import java.util.ArrayList;

public class Collision extends Component {

  /* Method settings for checkCollision */
  public ArrayList<Class> allow_entities = new ArrayList<>();

  public Collision() {
    super();
  }

  /* A bullet is allowed to collide with a zombie
   * but it is not allow to collide with a plant
   * The following method is to provide a list of
   * entities that an entity can collide with.
   * The method is a abstract, feel free to modified. */
  public Collision(ArrayList<Class> allow_entities) {
    super();
    this.allow_entities = allow_entities;
  }

  /* Method to check if a class belongs to the allowed list
   * created above. */
  public <T extends Entity> boolean allow(Class<T> cls) {
    for (var c : this.allow_entities) {
      if (c == cls) {
        return true;
      }
    }

    return false;
  }
}

