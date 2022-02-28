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

    /**
     * Find index that can complete circuit.
     * Solution: Greedy approach
     * Time: O(n) Space: O(1)
     * @param gas integer array of gas added each time.
     * @param cost integer array of gas cost deducted each time.
     * @return -1 if impossible, else index of circuit start.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;

        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {

            gasSum += gas[i];
            costSum += cost[i];

            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                start = i + 1;
            }
        }

        return (gasSum < costSum) ? -1 : start;
    }

    // Simple binary search insert position.
    public static int binarySearchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = right - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /**
     * Common function to generate array of factorials. Where the index associates with its factorial.
     * Solution: dynamic programming problem using tabulation.
     * Time: O(n) Space: O(n).
     * @param n the nth position we want factorials up to.
     * @return array of factorials up to specified nth number.
     */
    public static int[] generateFactorials(int n) {
        int[] f = new int[n+1];

        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i-1] * i;
        }

        return f;
    }

    /**
     * Rotate using extra memory.
     * Space: O(n).
     * @param nums integer array
     * @param k rotate k times
     * @return rotated array.
     */
    public static int[] rotateArray(int[] nums, int k) {
        if (k == nums.length) return nums;

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = (i+k) % nums.length;
            res[index] = nums[i];
        }

        return res;
    }

    /**
     * Rotate in place.
     * Space: O(1).
     * @param nums integer array.
     * @param k rotate by k.
     */
    public static void rotateArrayInPlace(int[] nums, int k) {
        k = k % nums.length;

        reverseFromTo(nums, 0, nums.length-1);
        reverseFromTo(nums, 0, k-1);
        reverseFromTo(nums, k, nums.length-1);
    }

    private static void reverseFromTo(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

    /**
     * Reverse array in place.
     * @param nums integer array list.
     */
    public static void reverseArray(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}
