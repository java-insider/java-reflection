package reflection;

public class App2 {

    public static void main(String[] args) throws Exception {
        Animal a1 = new Cat();
        a1.speak();

        var c = Cat.class;
        var constructor = c.getConstructor();
        Cat cat = constructor.newInstance();
        cat.speak();
    }
}
