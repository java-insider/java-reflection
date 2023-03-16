package reflection;

public class App3 {

    public static void main(String[] args) throws Exception {
        Animal cat = Factory.newAnimal("reflection.Cat");
        cat.speak();

        Animal dog = Factory.newAnimal("reflection.Dog");
        dog.speak();

        Animal sheep = Factory.newAnimal("reflection.Sheep");
        sheep.speak();
    }
}
