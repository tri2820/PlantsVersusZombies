package Manager;

import java.util.ArrayList;
import java.util.List;

/* The whole game shall have only one ECS.Systema, which will `iterate` in each time step */
/* For each iteration, for each entity, the ECS.Systema will check if that entity have a particular component
 and call suitable methods of the component instance belongs to that entity
 */

/* Since `System` is a Java keyword, name `ECS.Systema` instead*/
// TODO: make Systema Singleton
public class Systema {
    public List<Entity> entityList = new ArrayList<>();

    public void addEntity(Entity e) {
        this.entityList.add(e);
    }

    public void removeEntity(Entity e) {
        this.entityList.remove(e);
    }

    public boolean hasEntity(Entity e) {
        return this.entityList.contains(e);
    }

    void iterate() {
    }


}
