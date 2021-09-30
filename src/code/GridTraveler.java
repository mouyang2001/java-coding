package code;

import java.util.HashMap;

public class GridTraveler {
    HashMap<String, Integer> memo;

    public GridTraveler() {
        memo = new HashMap<>();
    }

    /**
     * Grid traveler problem recursive memoization.
     * Uses a hash table to store and fetch key value data.
     *
     * @param r rows.
     * @param c columns.
     */
    public int gridTraveler(int r, int c) {
        String key = String.valueOf(r) + ',' + c;
        if (memo.containsKey(key)) return memo.get(key);

        if (r == 1 && c == 1) return 1;
        if (r == 0 || c == 0) return 0;

        memo.put(key, gridTraveler(r-1, c) + gridTraveler(r, c-1));
        return memo.get(key);
    }
}
