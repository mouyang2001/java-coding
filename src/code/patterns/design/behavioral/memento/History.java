package code.patterns.design.behavioral.memento;

import java.util.Stack;

/**
 * Caretaker class.
 * This takes care of handling large amounts of mementos which record states.
 */
public class History {
    private Stack<EditorState> states = new Stack<>();

    public void push(EditorState state) {
        states.push(state);
    }

    public EditorState pop() {
        return states.pop();
    }
}
