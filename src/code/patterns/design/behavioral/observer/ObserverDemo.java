package code.patterns.design.behavioral.observer;

public class ObserverDemo {
    public static void main(String[] args) {
        Channel penguinz0 = new Channel();

        Subscriber s1 = new Subscriber("Matthew");
        Subscriber s2 = new Subscriber("Eve");
        Subscriber s3 = new Subscriber("Elon");

        s1.subscribeToChannel(penguinz0);
        s2.subscribeToChannel(penguinz0);
        s3.subscribeToChannel(penguinz0);

        penguinz0.subscribe(s1);
        penguinz0.subscribe(s2);
        penguinz0.subscribe(s3);

        penguinz0.upload("How to code");
    }
}
