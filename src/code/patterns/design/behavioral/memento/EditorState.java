package code.patterns.design.behavioral.memento;

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
