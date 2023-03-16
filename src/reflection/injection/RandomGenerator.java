package reflection.injection;

import java.util.Random;

public class RandomGenerator {
    private final Random random = new Random();

    @Inject
    private int min;

    @Inject
    private int max;

    public int next() {
        return random.nextInt(min, max + 1);
    }
}
