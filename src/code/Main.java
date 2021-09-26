package code;

import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        System.out.println(hasUnique("hello"));
        System.out.println(removeDupes("hello"));
        System.out.println("testing");
        System.out.println(fibonacciAdvanced(24));
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
        ArrayList<String> a = new ArrayList<>();
        LinkedHashSet<String> set = new LinkedHashSet<>();
        a.addAll(List.of(s.split("")));
        set.addAll(a);
        a.clear();
        a.addAll(set);

        return a;
    }

    public static void deleteDuplicateNodes(LinkedListNode head) {
        HashSet<Integer> uniqueNodes= new HashSet<>();
        uniqueNodes.add(head.value);

        LinkedListNode current = head;
        while (current != null) {
            current = current.next;

            if (uniqueNodes.contains(current.value)) {
                current.prev.next = current.next;
            }
        }
    }

    public static int fibonacci(int n) {
        if (n <= 2) return 1;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int[] fibArray = new int[26];
    public static int fibonacciAdvanced(int n) {
        if (n<=2) return 1;
        else if (fibArray[n] != 0) return fibArray[n];
        else {
            int fibValue = fibonacci(n-2) + fibonacci(n-1);
            fibArray[n] = fibValue;
            return fibValue;
        }
    }

}
