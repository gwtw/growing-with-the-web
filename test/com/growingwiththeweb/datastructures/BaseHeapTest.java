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

public abstract class BaseHeapTest {
    protected HeapInterface heap;

    @Before
    public abstract void setUp();

    @After
    public void tearDown() {
        heap = null;
    }

    @Test
    public void testInsert() {
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        assertEquals(5, heap.size());
    }

    @Test
    public void testExtractMinimumWithEmptyHeap() {
        assertEquals(null, heap.extractMin());
    }

    @Test
    public void testExtractMinimumItems() {
        heap.insert(5);
        heap.insert(3);
        heap.insert(4);
        heap.insert(1);
        heap.insert(2);
        assertSame(1, heap.extractMin());
        assertSame(2, heap.extractMin());
        assertSame(3, heap.extractMin());
        assertSame(4, heap.extractMin());
        assertSame(5, heap.extractMin());
    }

    @Test
    public void testExtractMinimumFromJumbledHeap() {
        heap.insert(1);
        heap.insert(4);
        heap.insert(3);
        heap.insert(5);
        heap.insert(2);
        assertSame(1, heap.extractMin());
        assertSame(2, heap.extractMin());
        assertSame(3, heap.extractMin());
        assertSame(4, heap.extractMin());
        assertSame(5, heap.extractMin());
    }

    @Test
    public void testExtractMinimumWithNegativeItems() {
        heap.insert(-9);
        heap.insert(6);
        heap.insert(3);
        heap.insert(10);
        heap.insert(-4);
        assertSame(-9, heap.extractMin());
        assertSame(-4, heap.extractMin());
        assertSame(3, heap.extractMin());
        assertSame(6, heap.extractMin());
        assertSame(10, heap.extractMin());
    }

    @Test
    public void testFindMinimumEmptyHeap() {
        assertSame(null, heap.min());
    }

    @Test
    public void testFindMinimum() {
        heap.insert(5);
        heap.insert(3);
        heap.insert(1);
        heap.insert(4);
        heap.insert(2);
        assertSame(1, heap.min());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(heap.isEmpty());
        heap.insert(1);
        assertFalse(heap.isEmpty());
        heap.extractMin();
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testClearSetsHeapSizeToZero() {
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.clear();
        assertSame(0, heap.size());
    }

    @Test
    public void testClearSetsHeapsMinNodeToNull() {
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.clear();
        assertSame(null, heap.min());
    }
}
