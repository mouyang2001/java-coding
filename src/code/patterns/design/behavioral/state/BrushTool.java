package code.patterns.design.behavioral.state;

public class BrushTool implements Tool {
    @Override
    public void mouseDown() {
        System.out.println("Selection Icon");
    }

    @Override
    public void mouseUp() {
        System.out.println("Draw dashed rectangle");
    }
}
