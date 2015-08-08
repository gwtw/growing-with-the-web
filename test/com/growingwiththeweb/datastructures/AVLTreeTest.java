package com.growingwiththeweb.datastructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class AVLTreeTest {
    @Test
    public void testInsertElements() {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        assertEquals("size should be 0", 0, tree.getSize());
        tree.insert(1);
        assertEquals("size should be 1", 1, tree.getSize());
        tree.insert(2);
        assertEquals("size should be 2", 2, tree.getSize());
        tree.insert(3);
        assertEquals("size should be 3", 3, tree.getSize());
    }

    @Test
    public void testNoDuplicateInsertionSingleElement() {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        assertEquals("size should be 0", 0, tree.getSize());
        tree.insert(1);
        assertEquals("size should be 1", 1, tree.getSize());
        tree.insert(1);
        assertEquals("size should be 1", 1, tree.getSize());
    }

    @Test
    public void testNoDuplicateInsertionMultipleElements() {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        assertEquals("size should be 0", 0, tree.getSize());
        tree.insert(3);
        assertEquals("size should be 1", 1, tree.getSize());
        tree.insert(3);
        assertEquals("size should be 1", 1, tree.getSize());
        tree.insert(1);
        assertEquals("size should be 2", 2, tree.getSize());
        tree.insert(1);
        assertEquals("size should be 2", 2, tree.getSize());
        tree.insert(2);
        assertEquals("size should be 3", 3, tree.getSize());
        tree.insert(2);
        assertEquals("size should be 3", 3, tree.getSize());
        tree.insert(4);
        assertEquals("size should be 4", 4, tree.getSize());
        tree.insert(4);
        assertEquals("size should be 4", 4, tree.getSize());
    }
}
