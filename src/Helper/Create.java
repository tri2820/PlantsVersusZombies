package Helper;

import Manager.Component;

import java.lang.reflect.InvocationTargetException;

// don't need
public class Create {
    public static <T extends Component> T ComponentInstance(Class<T> component_type) {
        T component = null;
        try {
            component = component_type.getConstructor().newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return component;
    }
}
