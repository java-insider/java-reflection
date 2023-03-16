package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Factory {

    public static Animal newAnimal(String className) throws Exception {
        Class<?> theClass = Class.forName(className);
        var constructor = theClass.getConstructor();
        Animal animal = (Animal) constructor.newInstance();

        try {
            Method afterConstructorMethod = theClass.getMethod("afterConstructor");
            afterConstructorMethod.invoke(animal);
        } catch (NoSuchMethodException e) {
        }

        Arrays
            .stream(theClass.getDeclaredMethods())
            .forEach(m -> {
                if (m.getAnnotation(OnCreated.class) != null) {
                    try {
                        m.setAccessible(true);
                        m.invoke(animal);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

        return animal;
    }
}
