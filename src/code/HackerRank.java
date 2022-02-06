package code;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HackerRank {

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Collections.sort(ar);

        int l = 0;
        int r = 0;
        int pairs = 0;
        while (r < n) {
            if (ar.get(r) == ar.get(l)) {
                r++;
            } else {
                pairs += (r-l) / 2;
                l = r;
            }
        }

        return pairs;
    }
}
