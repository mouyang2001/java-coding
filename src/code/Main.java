package code;

import code.http.Requests;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(LeetCode.findAnagrams("cbaebabacd", "abc"));
        System.out.println(LeetCode.findAnagrams2("cbaebabacd", "abc"));
        System.out.println(LeetCode.findAnagrams3("cbaebabacd", "abc"));
    }
}
