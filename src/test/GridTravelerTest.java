package test;

import code.GridTraveler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GridTravelerTest {

    GridTraveler g;

    @Before
    public void before() {
        g = new GridTraveler();
    }

    @Test
    public void testGridTravelerOnBasics() {
        assertEquals(1, g.gridTraveler(1,1));
        assertEquals(3, g.gridTraveler(2,3));
        assertEquals(3, g.gridTraveler(3,2));
        assertEquals(6, g.gridTraveler(3,3));
    }
}
