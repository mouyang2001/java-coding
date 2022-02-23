package code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommonProblems {
    /**
     * Incredibly common algorithm for checking anagrams
     * Time: nlog(n) Space: n
     * @param s1 string 1
     * @param s2 string 2
     * @return true if string 1 and string 2 are anagrams
     */
    public static boolean isAnagram(String s1, String s2) {
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();

        Arrays.sort(a1);
        Arrays.sort(a2);

        // Or a while loop
        return Arrays.equals(a1, a2);
    }

    public static void loopThroughHashMap(HashMap<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }

    public static void firstAndLastIndex(int[] arr) {

    }
}
