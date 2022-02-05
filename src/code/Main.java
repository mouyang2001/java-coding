package code;

import code.http.Requests;
import code.patterns.memento.Editor;
import code.patterns.memento.History;
import code.patterns.singleton.Singleton;
import code.patterns.state.Canvas;
import code.patterns.state.SelectionTool;

import java.io.IOException;
import java.security.Signature;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        leetcodeDebugging();

        mementoExample();
        stateExample();
        singletonExample();
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
}
