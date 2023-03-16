package reflection;

import java.util.Arrays;

public class App6 {

    public static void main(String[] args) throws Exception {
        Person person = new Person();

        var theClass = person.getClass();

        Arrays
            .stream(theClass.getDeclaredFields())
            .forEach(f -> {
                try {
                    f.setAccessible(true);
                    if (f.getName().equals("id")) {
                        f.set(person, 10);
                    } else if (f.getName().equals("name")) {
                        f.set(person, "Pedro");
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            });

        System.out.println(person);
    }
}
