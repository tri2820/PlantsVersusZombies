import java.lang.reflect.InvocationTargetException;


class ECS_helper {
    static <T extends Component> T createComponentInstance(Class<T> component_type) {
        T component = null;
        try {
            component = component_type.getConstructor().newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return component;
    }
}
