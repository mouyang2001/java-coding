package code;

import code.patterns.design.behavioral.chainOfResponsibility.*;
import code.patterns.design.behavioral.memento.Editor;
import code.patterns.design.behavioral.memento.History;
import code.patterns.design.behavioral.observer.Channel;
import code.patterns.design.behavioral.observer.Subscriber;
import code.patterns.design.creational.builder.User;
import code.patterns.design.creational.builder.UserBuilder;
import code.patterns.design.creational.factory.Dialog;
import code.patterns.design.creational.factory.HtmlDialog;
import code.patterns.design.creational.factory.WindowsDialog;
import code.patterns.design.creational.singleton.Singleton;
import code.patterns.design.behavioral.state.Canvas;
import code.patterns.design.behavioral.state.SelectionTool;
import code.patterns.architectural.mvc.Student;
import code.patterns.architectural.mvc.StudentController;
import code.patterns.architectural.mvc.StudentView;
import code.patterns.design.structural.adapter.RoundHole;
import code.patterns.design.structural.adapter.RoundPeg;
import code.patterns.design.structural.adapter.SquarePeg;
import code.patterns.design.structural.adapter.SquarePegAdapter;
import code.patterns.design.structural.bridge.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        leetcodeDebugging();

        // Design Patterns
//        mementoExample();

//        stateExample();

//        singletonExample();

//        observerExample();

//        builderExample();

//        bridgeExample(new TV());
//        bridgeExample(new Radio());

//        adapterExample();

//         factoryExample();

        // Architectural Patterns
//        mvcExample();
    }

    public static void leetcodeDebugging() {
        char[][] sea = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
            };

        System.out.println(LeetCode.numIslands(sea));
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

    public static void adapterExample() {
        RoundHole hole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(5);
        if (hole.fits(roundPeg)) System.out.println("Round peg r5 fits round hole r5");

        SquarePeg squarePeg = new SquarePeg(2);
        SquarePegAdapter squarePegAdapter = new SquarePegAdapter(squarePeg);
        // The reason why squarePegAdapter is allowed. Because it's an aggregate / extension of round peg.
        if (hole.fits(squarePegAdapter)) System.out.println("Square peg w2 fits round hole r5");
    }

    public static void chainOfResponsibility() {
        Chain operation1 = new AddNumbers();
        Chain operation2 = new SubtractNumbers();
        Chain operation3 = new MultiplyNumbers();
        Chain operation4 = new DivideNumbers();

        operation1.setNextChain(operation2);
        operation2.setNextChain(operation3);
        operation3.setNextChain(operation4);

        Numbers request = new Numbers(4, 2, "div");
        // Because "div" is not operation1 it will pass it down the chain until one of the operation chains can process it.
        operation1.calculate(request);
    }

    public static void factoryExample() {
        Dialog dialog;
        if (System.getProperty("os.name").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }

        dialog.renderWindow();
    }
}
