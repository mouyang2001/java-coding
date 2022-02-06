package code.patterns.architectural.observer;

public class Subscriber {
    private final String name;
    private Channel channel = new Channel();

    public Subscriber(String name) {
        this.name = name;
    }

    public void update() {
        System.out.println(name + " got video from channel: " + channel.getTitle());
    }

    public void subscribeToChannel(Channel channel) {
        this.channel = channel;
    }
}
