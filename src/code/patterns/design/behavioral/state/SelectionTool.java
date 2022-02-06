package code.patterns.design.behavioral.state;

public class SelectionTool implements Tool {

    @Override
    public void mouseDown() {
        System.out.println("Display selection tool");
    }

    @Override
    public void mouseUp() {
        System.out.println("Draw rectangle");
    }
}
