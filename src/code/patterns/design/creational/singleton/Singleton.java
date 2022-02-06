package code.patterns.design.creational.singleton;

import java.util.Random;

/**
 * Singleton is a creational design pattern that ensures a class only has a single instance and allows
 * global access point.
 *
 * Pros: Single instance, global access and initializes on first request.
 * Cons: Violates SRP, Multithreading need to make sure multiple instances aren't created.
 */
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
