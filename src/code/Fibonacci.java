package code;

public class Fibonacci {
    private int[] mem;

    public Fibonacci(int n) {
        this.mem = new int[n+1];
    }

    public int calculate(int n) {
        if (n<=2) return 1;
        else if (mem[n] != 0) return mem[n];
        else {
            int fibValue = calculate(n-2) + calculate(n-1);
            mem[n] = fibValue;
            return fibValue;
        }
    }

    public int calculateT(int n) {
        int[] table = new int[n+1];
        table[1] = 1;
        for (int i = 0; i <= n; i++) {
            table[i+1] += table[i];
            table[i+2] += table[i];
        }

        return table[n];
    }
}
