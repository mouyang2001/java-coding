package code.patterns.design.structural.bridge;

public class BridgeDemo {
    public static void main(String[] args) {
        bridge(new TV());
        bridge(new Radio());
    }

    public static void bridge(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
