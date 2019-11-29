package helper;

import component.BaseComponent;
import java.lang.reflect.InvocationTargetException;

public class ECS {

  public static <T extends BaseComponent> T emptyInstance(Class<T> component_type) {
    T component = null;
    try {
      component = component_type.getConstructor().newInstance();
    } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
      e.printStackTrace();
    }
    return component;
  }
}
