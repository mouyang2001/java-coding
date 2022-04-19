package code;

import java.util.*;

public class LeetCode {
    public static boolean hasUnique(String s) {
        String[] letters = s.split("");
        HashSet<String> set = new HashSet<>();

        for (String l : letters) {
            if (set.contains(l)) {
                return false;
            } else {
                set.add(l);
            }
        }

        return true;
    }

    // assuming all ascii characters, values 0 to 255
    public static boolean isUnique(String s) {
        boolean[] set = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if (set[val]) return false;
            else set[val] = true;
        }
        return true;
    }

    // remove duplicates in string
    public static ArrayList<String> removeDupes(String s) {
        ArrayList<String> a = new ArrayList<>(List.of(s.split("")));
        LinkedHashSet<String> set = new LinkedHashSet<>(a);
        a.clear();
        a.addAll(set);

        return a;
    }

    public static List<List<Integer>> threeSum(int [] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (nums[i] != nums[i-1])) {
                // two sum sliding window technique.
                int low = i + 1;
                int high  = nums.length-1;
                int sum = -nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        // Skip over duplicates.
                        while (low < high && nums[low] == nums[low+1]) low++;
                        while (low < high && nums[high] == nums[high-1]) high--;

                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > sum) {
                        high--;
                    } else  {
                        low++;
                    }
                }
            }
        }

        return res;
    }

    public static boolean isHappy(int n) {
        for (int i = 0; i < 100000; i++) {
            if (n == 1) return true;

            int square = 0;
            int m = n;
            while(m > 0) {
                square += (m%10) * (m%10);
                m/=10;
            }
            n=square;
        }
        return false;
    }

    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n%10;
            n /= 10;
        }

        return sum;
    }

    /**
     * This problem relied more on pattern recognition and deriving a mathematical relationship.
     * @param s the string we want to zigzag.
     * @param numRows the number of rows before zig zag folds.
     * @return string in zig zag form.
     */
    public static String zigZagPattern(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder res = new StringBuilder();
        for (int r = 0; r < numRows; r++) {
            int increment = 2 * (numRows - 1);
            for (int i = r; i < s.length(); i += increment) {
                res.append(s.charAt(i));

                // Check if r is a middle row.
                if (r > 0 && r < numRows-1) {
                    // If it is then calculate index of middle character.
                    int middleIndex = i + increment - (2*r);

                    // Check if middle index out of bounds first.
                    if (middleIndex < s.length()) {
                        res.append(s.charAt(middleIndex));
                    }
                }
            }
        }

        return res.toString();
    }


    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    /**
     * Find anagrams solution using hashmaps, slowest.
     * @param s string of letters
     * @param p pattern for anagrams
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> pCount = new HashMap<>();
        HashMap<Character, Integer> sCount = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            pCount.put(p.charAt(i), pCount.getOrDefault(p.charAt(i), 0) + 1);
            sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (pCount.equals(sCount)) res.add(0);

        int l = 0;
        for (int r = p.length(); r < s.length(); r++) {
            sCount.put(s.charAt(r), sCount.getOrDefault(s.charAt(r), 0) + 1);
            sCount.put(s.charAt(l), sCount.get(s.charAt(l)) - 1);

            if (sCount.get(s.charAt(l)) == 0) sCount.remove(s.charAt(l));

            l++;

            if (sCount.equals(pCount)) res.add(l);
        }

        return res;
    }

    /**
     * Find anagrams solution using int[26] arrays.
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if(p.length() > s.length()) return result;

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for(int i = 0; i < p.length(); i++){
            pCount[(int) p.charAt(i) - 'a']++;
            sCount[(int) s.charAt(i) - 'a']++;
        }

        if(Arrays.equals(pCount, sCount)) result.add(0);

        int l = 0;
        for(int r = p.length(); r < s.length(); r++){
            sCount[(int)s.charAt(r) - 'a']++;
            sCount[(int)s.charAt(l) - 'a']--;
            if (Arrays.equals(pCount, sCount)) result.add(l+1);

            l++;
        }
        return result;
    }

    /**
     * Find anagrams clean version but 2nd fastest.
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams3(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length()) return result;

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for(int i = 0; i < p.length(); i++){
            pCount[(int) p.charAt(i) - 'a']++;
            sCount[(int) s.charAt(i) - 'a']++;
        }

        if(Arrays.equals(pCount, sCount)) result.add(0);

        for (int i = 0; i < s.length() - p.length(); i++) {
            sCount[(int)s.charAt(i + p.length()) - 'a']++;
            sCount[(int)s.charAt(i) - 'a']--;
            if (Arrays.equals(pCount, sCount)) result.add(i+1);
        }

        return result;
    }

    public static int arrangeCoins(int n) {
        // Note long is better for storing larger numbers
        // Whereas double is better for more precise (more decimal points).
        return (int) (Math.sqrt(8* (long) n + 1) - 1) / 2;
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if (map.containsKey(c)) {
                return new int[]{map.get(c), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }

    public static int findMaxLengthContiguous(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) nums[i] = -1;
        }

        int sum = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum)){
                int prevIndex = map.get(sum);
                max = Math.max(max, i - prevIndex);
            }
            else{
                map.put(sum, i);
            }
        }
        return max;
    }

    public static int binarySearch(int[] nums, int target) {
        Arrays.sort(nums);

        int l = 0, r = nums.length -1;
        while (l <= r) {
            int m = (l+r) / 2;

            if (target < nums[m]) r = m - 1;
            else if (target > nums[m]) l = m - 1;
            else return m;
        }

        return -1;
    }

    /**
     * Find the smallest value index in sorted array using binary search.
     * This is assuming sorted array is scrambled.
     * @param nums nums integer array
     * @return smallest integer
     */
    public static int findSmallestIndexBinary(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = (l+r)/2;
            if (nums[m] > nums[r]) l = m + 1;
            else r = m;
        }

        return l;
    }

    public static int removeDuplicates(int[] nums) {
        var n = nums.length;
        if (n < 3)
            return n;

        var i = 2;
        for (var j = i; j < n; j++)
            if (nums[j] != nums[i - 2])
                nums[i++] = nums[j];

        return i;
    }

    public static long repeatedString(String s, long n) {
        // Write your code here
        long aCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') aCount++;
        }

        aCount = aCount * (n / s.length());

        for (int i = 0; i < n % s.length(); i++) {
            if (s.charAt(i) == 'a') aCount++;
        }

        return aCount;
    }

    public static char findTheDifference(String s, String t) {
        if (s.length() == 0) return t.charAt(0);

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for (char c : s.toCharArray()) {
            map1[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            map2[c-'a']++;
            if (map2[c-'a'] > map1[c - 'a']) {
                return c;
            }
        }

        return 'a';
    }

    public static int minimumSwaps(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i+1) {
                swap(arr, i, arr[i]-1);
                swaps++;
            }
        }
        return swaps;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int trap(int[] height) {
        int l = 0;
        int r = height.length-1;

        int maxL = height[l];
        int maxR = height[r];

        int total = 0;

        while (l < r) {
            int water = 0;
            if (maxL <= maxR) {
                l++;
                maxL = Math.max(maxL, height[l]);
                water = Math.min(maxL, maxR) - height[l];
            }  else {
                r--;
                maxR = Math.max(maxR, height[r]);
                water = Math.min(maxL, maxR) - height[r];
            }

            if (water > 0) total += water;
        }

        return total;
    }

    public static int numIslands(char[][] grid) {
        int islandCount = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    exploreIsland(grid, r, c);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    public static void exploreIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') return;
        System.out.println(Arrays.deepToString(grid));
        grid[i][j] = '0';
        exploreIsland(grid, i+1, j);
        exploreIsland(grid, i-1, j);
        exploreIsland(grid, i, j+1);
        exploreIsland(grid, i, j-1);
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int partition = partition(nums, low, high);
            quickSort(nums, low, partition - 1);
            quickSort(nums, partition + 1, high);
        }
    }

    // partition return index of pivot
    // But also sorts sub arrays left and right of the pivot.
    static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // or random or median of three

        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return (i + 1);
    }

    /**
     * Approach: put down the max number up to or current number + number two places before it.
     * @param arr
     * @return
     */
    static int maxSubsetSum(int[] arr) {
        if (arr.length == 1) return arr[0];

        int max = Math.max(arr[0], arr[1]);
        arr[1] = max;

        for (int i = 2; i < arr.length; i++) {
            max = Math.max(max, arr[i-2] + arr[i]);
            max = Math.max(max, arr[i]);
            arr[i] = max;
        }

        return max;
    }

    static int goodNumbers(int[] numbers) {
        Arrays.sort(numbers);

        // default all individual values are counted
        int ans = numbers.length;

        // Sliding window
        for (int l = 0; l < numbers.length-1; l++) {

            // if next value is the same one ignore it
            if (numbers[l] == numbers[l+1]) continue;


            int r = l;
            // Move r pointer each time the next value is the same or greater by 1.
            while (r < numbers.length - 1 && (numbers[r + 1] == numbers[r] + 1 || numbers[r+1] == numbers[r])) {
                ans++;
                r++;
            }
        }

        return ans;
    }

    static int maximumStockLeft(int[] arr, int m) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count up frequencies of unique values.
        // Add to priority queue.
        for (int n: arr) map.put(n, map.getOrDefault(n, 0) + 1);
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) queue.add(pair.getValue());

        System.out.println(queue);

        while (m > 0) {
            if (m >= queue.peek()) {
                m -= queue.poll();
            } else {
                break;
            }
        }

        return queue.size();
    }

    public static List<Integer> partitionLabels(String s) {
        // Map stores index of last occurrences of each character.
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) map.put(s.charAt(i), i);

        List<Integer> res = new ArrayList<>();
        int prev = -1;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            max = Math.max(max, map.get(c));

            if (i == max) {
                res.add(max - prev);
                prev = max;
            }
        }

        return res;
    }

    public static String getSmallestString(int n, int k) {
        char[] res = new char[n];
        Arrays.fill(res, 'a');

        int sum = n;
        for (int i = n-1; i >=0; i--) {
            System.out.println(new String(res));
            if (sum == k) return new String(res);

            int val = (int) res[i] - 96;
            int shouldBe = k - sum + val;
            if (shouldBe >= 26) {
                res[i] = 'z';
                sum = sum - val + 26;
            } else {
                res[i] = (char) (96 + shouldBe);
                sum = sum - val + shouldBe;
            }
        }

        return new String(res);
    }

    public static void swapRC(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}
