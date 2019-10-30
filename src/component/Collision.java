package component;

import entity.Entity;

import java.util.ArrayList;

public class Collision extends Component {
    /* Method settings for checkCollision */
    public ArrayList<Class> allow_entities = new ArrayList<>();
    public Collision() {
        super();
    }

    //please explain what does this do????
    public Collision(ArrayList<Class> allow_entities) {
        super();
        this.allow_entities = allow_entities;
    }

    //please explain what does this do?????
    public <T extends Entity> boolean allow(Class<T> cls) {
        for (var c : this.allow_entities)
            if (c == cls)
                return true;

        return false;
    }
}

