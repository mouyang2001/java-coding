package code.patterns.design.structural.bridge;

/**
 * Bridge is a structural design pattern that lets you split a large class or a set of closely related classes
 * into two separate hierarchies—abstraction and implementation—which can be developed independently of each other.
 *
 * Pros: Create platform-independent classes and apps. Open/closed introduce new abstractions independently of
 * one another. SRP, you can focus on high level logic in abstraction and platform details in the implementation.
 *
 * Cons: adds more complexity to highly cohesive classes (well-defined specific class)
 */
public class BasicRemote implements Remote {
    protected Device device;

    public BasicRemote() {}

    public BasicRemote(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
        System.out.println("Remote: power toggle");
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    @Override
    public void volumeDown() {
        System.out.println("Remote: volume down");
        device.setVolume(device.getVolume() - 10);
    }

    @Override
    public void volumeUp() {
        System.out.println("Remote: volume up");
        device.setVolume(device.getVolume() + 10);
    }

    @Override
    public void channelDown() {
        System.out.println("Remote: channel down");
        device.setChannel(device.getChannel() - 1);
    }

    @Override
    public void channelUp() {
        System.out.println("Remote: channel up");
        device.setChannel(device.getChannel() + 1);
    }
}
