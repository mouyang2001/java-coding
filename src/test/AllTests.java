package test;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MyHashMapTest.class,
        GridTravelerTest.class,
        FibonacciTest.class,
        LeetCodeTest.class
})
public class AllTests {};
