package code.patterns.design.behavioral.state;

public class StateDemo {
    public static void main(String[] args) {
        Canvas canvas = new Canvas();

        canvas.setCurrentTool(new SelectionTool());
        canvas.mouseDown();
        canvas.mouseUp();
    }
}
