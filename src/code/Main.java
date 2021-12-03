package code;

import code.http.Requests;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        letterCombinations("23");
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

}
