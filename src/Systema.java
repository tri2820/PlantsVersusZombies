import java.util.ArrayList;
import java.util.List;

/* The whole game shall have only one Systema, which will `iterate` in each time step */
/* For each iteration, for each entity, the Systema will check if that entity have a particular component
 and call suitable methods of the component instance belongs to that entity
 */

/* Since `System` is a Java keyword, name `Systema` instead*/
// TODO: make Systema Singleton
class Systema {
    List<Entity> entities = new ArrayList<>();

    //begin Singleton pattern
    protected Systema() {}

    private static class SingletonClassHolder {
        static final Systema SINGLE_INSTANCE = new Systema();
    }

    //access to single instance of Systema using Systema.getInstance()
    public static Systema getInstance() {
        return SingletonClassHolder.SINGLE_INSTANCE;
    }
    //end Singleton pattern

    void addEntity(Entity e) {
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
