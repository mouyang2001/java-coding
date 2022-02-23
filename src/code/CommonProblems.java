package code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommonProblems {
    /**
     * Incredibly common algorithm for checking anagrams.
     * Solutions: hashmap or lexicographic char sort.
     * Time: O(nlog(n)) Space: O(n)
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

    /**
     * Find first and last index of element in array.
     * Solutions: linear search or binary search.
     * Time: O(log(n)) Space: O(1).
     * @param arr integer array.
     * @param target target value.
     * @return [-1,-1] if nothing else the first and last indexes.
     */
    public static int[] findFirstAndLastIndex(int[] arr, int target) {
        return new int[] {findFirstIndex(arr, target), findLastIndex(arr, target)};
    }

    private static int findFirstIndex(int[] arr, int target) {
        int ans = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < arr[mid]) right = mid - 1;
            else if (target > arr[mid]) left = mid + 1;
            else {
                ans = mid;
                right = mid - 1;
            }
        }

        return ans;
    }

    private static int findLastIndex(int[] arr, int target) {
        int ans = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < arr[mid]) right = mid - 1;
            else if (target > arr[mid]) left = mid + 1;
            else {
                ans = mid;
                left = mid + 1;
            }
        }

        return ans;
    }
}
