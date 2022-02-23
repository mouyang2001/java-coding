package code;

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
        System.out.println(CommonProblems.isAnagram("hello", "elolh"));

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        CommonProblems.loopThroughHashMap(map);


    }
}
