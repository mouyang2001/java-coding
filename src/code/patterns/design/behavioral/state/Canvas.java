package code.patterns.design.behavioral.state;

/**
 * State is a behavioral design pattern that lets an object alter its behavior when its internal state changes.
 * It appears as if the object changed its class.
 *
 * Pros: upholds SRP by organising states into particular classes, open/close principle, introduce new states without
 * changing existing state or context, eliminates bulky state machine conditionals.
 *
 * Cons: can be easily abused if statemachine only as a few states. Eg spelling quiz, quiz mode and practice mode.
 */
public class Canvas implements Tool {

    private Tool currentTool;

    public void mouseDown() {
        currentTool.mouseDown();
    }

    public void mouseUp() {
        currentTool.mouseUp();
    }

    public Tool getCurrentTool () { return currentTool; }
    public void setCurrentTool (Tool newTool) { currentTool = newTool; }
}
