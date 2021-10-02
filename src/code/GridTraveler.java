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
     * @return number of possible paths.
     */
    public int gridTraveler(int r, int c) {
        String key = String.valueOf(r) + ',' + c;
        if (memo.containsKey(key)) return memo.get(key);

        if (r == 1 && c == 1) return 1;
        if (r == 0 || c == 0) return 0;

        memo.put(key, gridTraveler(r-1, c) + gridTraveler(r, c-1));
        return memo.get(key);
    }

    /**
     * Solves the Grid Traveler problem using tabulation.
     * Creates a table to tabulate path values.
     *
     * @param r grid rows.
     * @param c grid columns.
     * @return number of possible paths.
     */
    public int gridTravelerTable(int r, int c) {
        // Initiate table.
        int[][] matrix = new int[r+1][c+1];
        matrix[1][1] = 1;

        // Iterate through the table.
        for (int i = 0; i <= r; i++) {
            for (int j = 0; j <= c; j++) {
                // Check if '+1' to indexes are in bound.
                if (j+1 <= c) matrix[i][j+1] += matrix[i][j];
                if (i+1 <= r) matrix[i+1][j] += matrix[i][j];
            }
        }

        return matrix[r][c];
    }
}
