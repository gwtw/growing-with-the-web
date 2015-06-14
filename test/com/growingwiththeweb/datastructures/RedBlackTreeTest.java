package com.growingwiththeweb.datastructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class RedBlackTreeTest {

    @Test
    public void testAddInsertingElements() {
        RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
        //assertEquals("size should be 0", tree.size(), 0);
        assertTrue("insert should be successful", tree.insert(1));
        //assertEquals("size should be 1", tree.size(), 1);
        assertTrue("insert should be successful", tree.insert(2));
        //assertEquals("size should be 2", tree.size(), 2);
        assertTrue("insert should be successful", tree.insert(3));
        //assertEquals("size should be 3", tree.size(), 3);
    }

}
