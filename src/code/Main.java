package code;

import code.http.Requests;
import code.patterns.memento.Editor;
import code.patterns.memento.History;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        leetcodeDebugging();

        mementoExample();
    }

    public static void leetcodeDebugging() {
        int[] i = {2,7,11,15};
        System.out.println(Arrays.toString(LeetCode.twoSum(i, 9)));
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
}
