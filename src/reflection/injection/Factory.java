package reflection.injection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Factory {

    public static <T> T create(Class<T> theClass) {
        try {
            T instance = theClass.getConstructor().newInstance();

            for (Field f : theClass.getDeclaredFields()) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    f.setAccessible(true);
                    if (f.getAnnotation(Inject.class) != null) {
                        Method injectorMethod = Objects.class.getMethod(f.getName());
                        Object valueToInject = injectorMethod.invoke(null);
                        f.set(instance, valueToInject);
                    }
                }
            }

            return instance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
