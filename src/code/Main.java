package code;

import code.patterns.architectural.memento.Editor;
import code.patterns.architectural.memento.History;
import code.patterns.architectural.observer.Channel;
import code.patterns.architectural.observer.Subscriber;
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
        observerExample();

        // Architectural Patterns
        mvcExample();
    }

    public static void leetcodeDebugging() {
        int[] nums = {1,1};
        System.out.println(LeetCode.removeDuplicates(nums));
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

    public static void observerExample() {
        Channel penguinz0 = new Channel();

        Subscriber s1 = new Subscriber("Matthew");
        Subscriber s2 = new Subscriber("Eve");
        Subscriber s3 = new Subscriber("Elon");

        s1.subscribeToChannel(penguinz0);
        s2.subscribeToChannel(penguinz0);
        s3.subscribeToChannel(penguinz0);

        penguinz0.subscribe(s1);
        penguinz0.subscribe(s2);
        penguinz0.subscribe(s3);

        penguinz0.upload("How to code");
    }
}
