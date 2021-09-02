package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import code.MyHashMap;

public class Testing {
    MyHashMap<Integer, String> map;

    @Before
    public void setUp() {
        map = new MyHashMap<>();
    }

    @Test
    public void testMapPut() {
       map.put(1, "hello");
       assertEquals("hello", map.get(1));
    }

    @Test
    public void testOutput() {
        map.put(1, "hello");
        map.put(3, "hi");
        map.put(63, "greetings");

        System.out.println(map);
    }

    @Test
    public void testTrue() {
        assertTrue(true);
    }
}
