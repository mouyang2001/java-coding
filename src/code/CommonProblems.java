package code;

import java.util.*;

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

    /**
     * Find the kth largest element.
     * Solutions: sort then iterate backwards k times or heaps
     * @param arr integer array of numbers.
     * @param k the nth largest element.
     * @return the kth largest element in target array.
     */
    public static int kLargestElement(int[] arr,  int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        // nlog(n) slow because we need to heapify log(n) everytime, n times.
        // However, it could be O(n) if we heapify straight away.
        for (int n : arr) heap.add(n);

        for (int i = 0; i < k-1; i++) heap.remove(); // klog(n);

        return heap.remove();
    }

    /**
     * Check if string is valid parentheses containing '('.
     * Time: O(n) Space: O(n).
     * @param combination String combination of '(' and ')'.
     * @return boolean is valid parentheses.
     */
    public static boolean isValidParentheses(String combination) {
        Stack<Character> stack = new Stack<>();

        for (char c : combination.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                // Check if empty before popping
                if (stack.size() == 0) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static List<String> generateParentheses(int pairs) {
        List<String> combinations = new ArrayList<>();
        recursive(pairs, 0, 0, combinations, "");
        return combinations;
    }

    private static void recursive(int limit, int open, int close, List<String> combinations, String combo) {
        if (open > limit || close > limit || close > open) return;

        if (open == limit && close == limit) {
            combinations.add(combo);
            return;
        }

        recursive(limit, open+1, close, combinations, combo+"(");
        recursive(limit, open, close+1, combinations, combo+")");
    }
}
