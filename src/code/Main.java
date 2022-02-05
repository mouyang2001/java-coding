package code;

import code.patterns.architectural.memento.Editor;
import code.patterns.architectural.memento.History;
import code.patterns.architectural.singleton.Singleton;
import code.patterns.architectural.state.Canvas;
import code.patterns.architectural.state.SelectionTool;
import code.patterns.design.mvc.Student;
import code.patterns.design.mvc.StudentController;
import code.patterns.design.mvc.StudentView;

public class Main {
    public static void main(String[] args) {
        leetcodeDebugging();

        // Design Patterns
        mementoExample();
        stateExample();
        singletonExample();

        // Architectural Patterns
        mvcExample();
    }

    public static void leetcodeDebugging() {
        int[] nums = {1,5,6,2,3,7,2,8};
        System.out.println(LeetCode.binarySearch(nums, 2));
    }

    public static void mementoExample() {
        Editor editor = new Editor();
        History history = new History();

        editor.setContent("a");
        history.push(editor.createState());

        editor.setContent("b");
        history.push(editor.createState());

        editor.setContent("c");
        editor.restore(history.pop());

        System.out.println(editor.getContent());
    }

    public static void stateExample() {
        Canvas canvas = new Canvas();

        canvas.setCurrentTool(new SelectionTool());
        canvas.mouseDown();
        canvas.mouseUp();
    }

    public static void singletonExample() {
        Singleton singletonA = Singleton.getInstance();
        Singleton singletonB = Singleton.getInstance();

        System.out.println(singletonA.getRandomNumber());
        System.out.println(singletonB.getRandomNumber());
    }

    public static void mvcExample() {
        Student model = fetchStudentFromDatabase();
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();
    }
    public static Student fetchStudentFromDatabase() {
        Student student = new Student();
        student.setName("Matthew");
        student.setRollNo("13PR");
        return student;
    }
}
