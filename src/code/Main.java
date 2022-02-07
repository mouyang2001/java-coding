package code;

import code.patterns.design.behavioral.memento.Editor;
import code.patterns.design.behavioral.memento.History;
import code.patterns.design.behavioral.observer.Channel;
import code.patterns.design.behavioral.observer.Subscriber;
import code.patterns.design.creational.builder.User;
import code.patterns.design.creational.builder.UserBuilder;
import code.patterns.design.creational.singleton.Singleton;
import code.patterns.design.behavioral.state.Canvas;
import code.patterns.design.behavioral.state.SelectionTool;
import code.patterns.architectural.mvc.Student;
import code.patterns.architectural.mvc.StudentController;
import code.patterns.architectural.mvc.StudentView;
import code.patterns.design.structural.bridge.*;

public class Main {
    public static void main(String[] args) {
        leetcodeDebugging();

        // Design Patterns
//        mementoExample();
//        stateExample();
//        singletonExample();
//        observerExample();
//        builderExample();
        bridgeExample(new TV());
        bridgeExample(new Radio());

        // Architectural Patterns
        mvcExample();
    }

    public static void leetcodeDebugging() {
        int[] nums = {1,1};
        System.out.println(LeetCode.repeatedString("aba", 10));
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

    public static void builderExample() {
        UserBuilder userBuilder = new UserBuilder("Matthew", "Ouyang")
                .age(20)
                .phone("123456")
                .address("Auckland New Zealand");

        User user = userBuilder.build();
        System.out.println(user.toString());
    }

    public static void bridgeExample(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
