package code.patterns.design.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects
 * any events that happen to the object they’re observing.
 *
 * Pros: Upholds open/close principle, allowing you to introduce new subscriber classes without changing publisher code,
 * establish relations between objects at runtime
 *
 * Cons: Subscribers are notified in random order. (will need extra code to solve).
 */
public class Channel {
    private List<Subscriber> subs = new ArrayList<>();
    private String title;

    public void subscribe(Subscriber sub) {
        subs.add(sub);
    }

    public void unsubscribe(Subscriber sub) {
        subs.remove(sub);
    }

    public void notifySubscribers() {
        for (Subscriber sub : subs) {
            sub.update();
        }
    }

    public void upload(String title) {
        this.title = title;
        notifySubscribers();
    }

    public String getTitle() {
        return title;
    }
}
