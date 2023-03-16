package reflection;

public class Dog implements Animal {

    public void afterConstructor() {
        System.out.println("afterConstructor()");
    }

    @Override
    public void speak() {
        System.out.println("Au-Au");
    }
}
