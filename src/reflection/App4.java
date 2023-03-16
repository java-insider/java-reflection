package reflection;

public class App4 {

    public static void main(String[] args) throws Exception {
        Animal animal = Factory.newAnimal("reflection." + args[0]);
        animal.speak();
    }
}
