package code;

import code.patterns.design.behavioral.chainOfResponsibility.*;
import code.patterns.design.creational.factory.Dialog;
import code.patterns.design.creational.factory.HtmlDialog;
import code.patterns.design.creational.factory.WindowsDialog;

public class Main {
    public static void main(String[] args) {
        leetcodeDebugging();
        commonProblems();
    }

    public static void leetcodeDebugging() {
        char[][] sea = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
            };

        int[] nums = {1,1,1,2,2,3};
        System.out.println(LeetCode.maximumStockLeft(nums, 2));
    }

    public static void commonProblems() {

    }
}
