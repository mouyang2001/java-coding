package code;

public class Fibonacci {
    private final int[] mem;

    public Fibonacci(int n) {
        this.mem = new int[n+1];
    }

    /**
     * Calculate Fibonacci numbers up to nth term.
     * Method utilizes memoization. Stores subtree values in a hashmap.
     * @param n the term to calculate up to.
     * @return fibonacci calculated value.
     */
    public int calculateMemoization(int n) {
        if (n<=2) return 1;
        else if (mem[n] != 0) return mem[n];
        else {
            int fibValue = calculateMemoization(n-2) + calculateMemoization(n-1);
            mem[n] = fibValue;
            return fibValue;
        }
    }

    public int calculateTabulation(int n) {
        int[] table = new int[n+10];
        table[1] = 1;
        for (int i = 0; i < n; i++) {
            table[i+1] += table[i];
            table[i+2] += table[i];
        }

        return table[n];
    }
}
