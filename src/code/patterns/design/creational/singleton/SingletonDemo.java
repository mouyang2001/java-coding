package code.patterns.design.creational.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1.getRandomNumber());
        System.out.println(singleton2.getRandomNumber());
    }
}
