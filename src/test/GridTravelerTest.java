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

    @Test
    public void testGridTravelerOnBasicsTabulation() {
        assertEquals(1, g.gridTravelerTable(1,1));
        assertEquals(3, g.gridTravelerTable(2,3));
        assertEquals(3, g.gridTravelerTable(3,2));
        assertEquals(6, g.gridTravelerTable(3,3));
    }

    @Test
    public void testGridTravelerOnLargeValuesTabulation() {
        assertEquals(705432, g.gridTraveler(12,12));
    }
}
