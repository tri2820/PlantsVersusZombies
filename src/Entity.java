import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/* Entity consists of components */
/* Each component is an aspect of the entity*/
/* Entity can inherit another entity */

class Entity {
    private Map<Class, Component> components = new HashMap<>();

    List<Component> getComponents() {
        return new ArrayList<>(components.values());
    }

    <T extends Component> T getComponent(Class<T> component_type) {
        T component = component_type.cast(this.components.get(component_type));
        if (component == null)
            throw new Error("Cannot get component " + component_type + " from " + this);
        else
            return component;
    }

    <T extends Component> boolean hasComponent(Class<T> component_type) {
        return components.containsKey(component_type);
    }

    <T extends Component> void addComponent(Class<T> component_type) {
        if (hasComponent(component_type))
            throw new Error("Cannot addComponent, " + this + " has " + component_type + " already");

        var component = ECS_helper.createComponentInstance(component_type);
        component.setEntity(this);
        this.components.put(component_type, component);
    }

    <T extends Component> void removeComponent(Class<T> component_type) {
        this.components.remove(component_type);
    }

}
