package code;

import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        System.out.println(hasUnique("hello"));
        System.out.println(removeDupes("hello"));
        System.out.println(isUnique("hello"));
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
