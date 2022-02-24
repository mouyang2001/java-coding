package code;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        leetcodeDebugging();
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
        // Check if two strings are anagrams.
        System.out.println(CommonProblems.isAnagram("hello", "elolh"));

        // Iterate over hashmap.
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        CommonProblems.loopThroughHashMap(map);

        // Find first and last index in sorted array.
        int[] nums = {1,1,2,2,2,3,3};
        int[] firstAndLastIndex = CommonProblems.findFirstAndLastIndex(nums, 2);
        System.out.println(Arrays.toString(firstAndLastIndex));

        // Find k largest element.
        System.out.println(CommonProblems.kLargestElement(new int[]{3,2,1,5,6,4}, 2));

        // Is valid parentheses.
        System.out.println(CommonProblems.isValidParentheses("(()()(()))"));

        // generate all valid parentheses.
        System.out.println(CommonProblems.generateParentheses(3));
    }
}
