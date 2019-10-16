package Systems;

import java.util.ArrayList;
import java.util.List;

/* The whole game shall have only one ECS.Systema, which will `iterate` in each time step */
/* For each iteration, for each entity, the ECS.Systema will check if that entity have a particular component
 and call suitable methods of the component instance belongs to that entity
 */

/* Since `System` is a Java keyword, name `ECS.Systema` instead*/
// TODO: make ECS.Systema Singleton
class Systema {
    List<Entity> entities = new ArrayList<>();

    public void addEntity(Entity e) {
        this.entities.add(e);
    }

    void removeEntity(Entity e) {
        this.entities.remove(e);
    }

    boolean hasEntity(Entity e) {
        return this.entities.contains(e);
    }

    void iterate() {
    }
}
