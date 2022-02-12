package code.patterns.design.behavioral.command;

/**
 * Command is behavioral design pattern that converts requests or simple operations into objects.
 * The conversion allows deferred or remote execution of commands, storing command history, etc.
 *
 * Pros:
 * SRP, decouple classes that invoke operations from classes that perform these operations.
 * Open/Closed principle, introduce new commands without breaking existing code.
 * Assemble multiple commands into complex ones.
 *
 * Cons:
 * Increase complexity, since ur introducing a whole new layer between senders and receivers.
 *
 */
public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.init();
    }
}
