package test;

import code.LeetCode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCodeTest {

    @Test
    public void testZigZagPattern() {
        assertEquals(LeetCode.zigZagPattern("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
        assertEquals(LeetCode.zigZagPattern("PAYPALISHIRING", 4), "PINALSIGYAHRPI");
    }

}
