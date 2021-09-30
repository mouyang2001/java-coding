package test;

import code.Fibonacci;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {
    Fibonacci f;

    @Before
    public void setup() {
        f = new Fibonacci(1000);
    }

    @Test
    public void testFibonacciMemoization() {
        int[] fibonacciNumbers = {1,1,2,3,5,8,13};
        for (int i = 0; i < fibonacciNumbers.length; i++) {
            assertEquals(fibonacciNumbers[i], f.calculateMemoization(i+1));
        }
    }

    @Test
    public void testFibonacciTabulation() {
        int[] fibonacciNumbers = {0,1,1,2,3,5,8,13};
        for (int i = 0; i < fibonacciNumbers.length; i++) {
            assertEquals(fibonacciNumbers[i], f.calculateTabulation(i));
        }
    }
}
