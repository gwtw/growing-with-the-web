package com.growingwiththeweb.dataStructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class BinaryHeapTest {

    @Test
    public void testInsert() {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>();
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        assertEquals("size should be 5", heap.size(), 5);
    }

    @Test
    public void testExtractMinimumWithEmptyHeap() {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>();
        assertEquals("should be null", heap.extractMin(), null);
    }

}
