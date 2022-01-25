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

}
