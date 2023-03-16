package reflection;

import java.util.Arrays;

public class App1 {

    public static void main(String[] args) {

        Class<String> c = String.class;

        String name = c.getName();
        System.out.println(name);

        String classPackage = c.getPackageName();
        System.out.println(classPackage);

        String simpleName = c.getSimpleName();
        System.out.println(simpleName);

        Class<App1> c2 = App1.class;
        System.out.println(Arrays.toString(c2.getMethods()));

        String s = "abc";
        Class<? extends String> c3 = s.getClass();
    }
}
