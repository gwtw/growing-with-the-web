package com.growingwiththeweb.designpatterns.singleton;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class LazyLoadingSingletonTest {
    @Test
    public void testLazyLoadingSingleton() {
        LazyLoadingSingleton a = LazyLoadingSingleton.getInstance();
        LazyLoadingSingleton b = LazyLoadingSingleton.getInstance();
        assertTrue(a != null);
        assertTrue(b != null);
        assertEquals(a, b);
    }
}
