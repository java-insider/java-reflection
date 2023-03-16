package reflection;

public class Cat implements Animal {

    @OnCreated
    public void setup() {
        System.out.println("setup()");
    }

    @OnCreated
    private void setup2() {
        System.out.println("setup2()");
    }

    @Override
    public void speak() {
        System.out.println("Miau");
    }
}
