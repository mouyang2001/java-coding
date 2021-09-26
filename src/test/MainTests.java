package test;

import org.junit.Test;
import org.junit.Before;

import static code.Main.fibonacciAdvanced;
import static org.junit.Assert.assertEquals;

import static code.Main.fibonacci;
import static code.Main.fibonacciAdvanced;

public class MainTests {
    @Before
    public void setup() {

    }

    @Test
    public void testFibonacci() {
        int[] fnums = {1,1,2,3,5,8,13};
        for (int i = 0; i < fnums.length; i++) {
            assertEquals(fnums[i], fibonacci(i+1));
        }
    }

    @Test
    public void testFibonacciAdvanced() {
        int[] fnums = {1,1,2,3,5,8,13};
        for (int i = 0; i < fnums.length; i++) {
            assertEquals(fnums[i], fibonacciAdvanced(i+1));
        }
    }
}
