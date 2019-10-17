package entity;

import component.Component;

import java.util.ArrayList;
import java.util.HashMap;


public class Entity {
    private HashMap<Class, Component> components = new HashMap<>();

    /* Getter for components */
    public ArrayList<Component> components() {
        return new ArrayList<>(components.values());
    }

    /* Check if entity is having a component of given type */
    public <T extends Component> boolean has(Class<T> component_type) {
        return components.containsKey(component_type);
    }

    /* Add component using its type*/
    public <T extends Component> void add(Class<T> component_type) {
        if (has(component_type))
            throw new RuntimeException("Cannot addComponent, " + this + " has " + component_type + " already");
        var component = helper.ECS.emptyInstance(component_type);
        component.owner(this);
        this.components.put(component_type, component);
    }

    /* Add component using an instance*/
    public <T extends Component> void add(T component) {
        if (has(component.getClass()))
            throw new RuntimeException("Cannot addComponent, " + this + " has " + component.getClass() + " already");
        component.owner(this);
        this.components.put(component.getClass(), component);
    }

    /* Remove component by using its type */
    public <T extends Component> void remove(Class<T> component_type) {
        this.components.remove(component_type);
    }

    /* Get component using its type */
    public <T extends Component> T get(Class<T> component_type) {
        T component = component_type.cast(this.components.get(component_type));
        if (component == null) throw new RuntimeException("Cannot get component " + component_type + " from " + this);
        return component;
    }
}
