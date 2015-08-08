package com.growingwiththeweb.datastructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public abstract class BaseBinarySearchTreeTest {
    protected BinarySearchTreeInterface tree;

    @Before
    public abstract void setUp();

    @After
    public void tearDown() {
        tree = null;
    }

    @Test
    public void testInsertSingleElement() {
        assertEquals(0, tree.size());
        tree.insert(1);
        assertEquals(1, tree.size());
    }

    @Test
    public void testInsertMultipleElement() {
        assertEquals(0, tree.size());
        tree.insert(1);
        assertEquals(1, tree.size());
        tree.insert(2);
        assertEquals(2, tree.size());
        tree.insert(3);
        assertEquals(3, tree.size());
    }
}
