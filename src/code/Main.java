package code;

import code.design.FileSystem;
import test.LeetCodeTest;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        leetcodeDebugging();
//        commonProblems();
//        designProblems();
    }

    public static void leetcodeDebugging() {
        char[][] sea = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
            };

        int[] nums = {1,1,1,2,2,3};
        System.out.println(LeetCode.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(LeetCode.getSmallestString(4, 100));
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

        System.out.println(CommonProblems.binarySearchInsert(new int[] {1,3,5,6}, 5));

        System.out.println(Arrays.toString(CommonProblems.generateFactorials(5)));

        System.out.println(Arrays.toString(CommonProblems.rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7,}, 8)));

        System.out.println(Arrays.toString(CommonProblems.targetSeparation(new int[] {0,1,0,3,12}, 0)));

        Integer test = 10;
        System.out.println(test);

        System.out.println(CommonProblems.getMaxSubstrings("aababaabce", 3));

        System.out.println(CommonProblems.rotationalCipher("Zebra-493?", 3));

        System.out.println(CommonProblems.searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 23));

        CommonProblems.splitDigits(12345, 10);
        CommonProblems.splitDigits(11, 2);
    }

    public static void designProblems() {
        FileSystem fileSystem = new FileSystem();

        fileSystem.mkdir("/apps/src");
        fileSystem.addContentToFile("/apps/main.java", "System.out.println('Hello world');");
        System.out.println(fileSystem.ls("/apps"));
        System.out.println(fileSystem.readContentFromFile("/apps"));
    }
}
