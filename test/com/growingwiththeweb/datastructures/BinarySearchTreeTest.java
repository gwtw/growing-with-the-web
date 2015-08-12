package com.growingwiththeweb.datastructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class BinarySearchTreeTest extends BaseBinarySearchTreeTest {
    @Before
    @Override
    public void setUp() {
        tree = new BinarySearchTree<Integer>();
    }

    /**
     * delete(3), 5 should remain in the tree, there should not be duplicate
     * nodes for 4.
     * 1
     *  \
     *   3
     *  / \
     * 2   4
     *      \
     *       5
     */
    @Test
    public void testDeleteRegressionCaseOne() {
        tree.insert(1);
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(5);
        String treeBefore = tree.toString();
        assertEquals(5, tree.size());
        tree.delete(3);
        String treeAfter = tree.toString();
        assertNotSame(treeBefore.length(), treeAfter.length());
        System.out.println("After delete: " + tree.toString());
    }
}
