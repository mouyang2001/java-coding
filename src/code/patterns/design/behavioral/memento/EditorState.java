package code.patterns.design.behavioral.memento;

/**
 * Memento is a behavioral design pattern that lets you save and restore the previous state of an object without
 * revealing the details of its implementation.
 *
 * Pros: Produce snapshots of object's state without violating encapsulation, simplifies originator code by dedicating
 * history tracking to caretaker.
 * Cons: Might consume lots of ram, dynamic languages can't guarantee state remains untouched.
 */

/**
 * Memento class.
 * In a way it's a memento (small note) that stores state of originator.
 */
public class EditorState {

    private final String content;

    public EditorState(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
