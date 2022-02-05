package code.patterns.architectural.state;

public class EraserTool implements Tool {
    @Override
    public void mouseDown() {
        System.out.println("Display eraser icon");
    }

    @Override
    public void mouseUp() {
        System.out.println("Remove something");
    }
}
