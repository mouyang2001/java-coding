package code.patterns.singleton;

import java.util.Random;

public class Singleton {

    private static final Singleton singleton = new Singleton();
    private final int randomNumber;

    private Singleton () {
        Random random = new Random();
        randomNumber = random.nextInt(100);
    }

    public static Singleton getInstance() {
        return singleton;
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
