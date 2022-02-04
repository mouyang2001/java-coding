package code.patterns.state;

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
