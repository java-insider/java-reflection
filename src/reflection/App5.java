package reflection;

public class App5 {

    public static void main(String[] args) throws Exception {
        Animal animal = Factory.newAnimal("reflection.Cat");
        animal.speak();
    }
}
