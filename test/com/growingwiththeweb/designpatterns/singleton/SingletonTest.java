package com.growingwiththeweb.designpatterns.singleton;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class SingletonTest {
    @Test
    public void testLazyLoadingSingleton() {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();
        assertTrue(a != null);
        assertTrue(b != null);
        assertEquals(a, b);
    }
}
