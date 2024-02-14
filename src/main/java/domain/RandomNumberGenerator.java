package domain;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int UPPER_BOUND = 10;

    private final Random random = new Random();

    public int generate() {
        return random.nextInt(UPPER_BOUND);
    }
}