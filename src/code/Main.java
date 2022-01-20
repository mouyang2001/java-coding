package code;

import code.http.Requests;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(isHappy(82));
        System.out.println(sumOfDigits(1676));
    }

    public static List<String> letterCombinations(String digits) {
        String[][] dictionary = {
                {}, // 0
                {}, // 1
                {"a", "b", "c"}, // 2
                {"d", "e", "f"},
                {"g", "h", "i"},
                {"j", "k", "l"},
                {"m", "n", "o"},
                {"p", "q", "r", "s"},
                {"t", "u", "v"},
                {"w", "x", "y", "z"}
        };

        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            System.out.println(num);
//            System.out.println(Arrays.toString(dictionary[number]));
        }

        return null;
    }

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
}
