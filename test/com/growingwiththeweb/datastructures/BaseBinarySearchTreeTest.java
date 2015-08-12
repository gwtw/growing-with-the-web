package com.growingwiththeweb.datastructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
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

    @Test
    public void testInsertDuplicateElements() {
        tree.insert(3);
        assertEquals(1, tree.size());
        tree.insert(3);
        assertEquals(1, tree.size());
        tree.insert(1);
        assertEquals(2, tree.size());
        tree.insert(1);
        assertEquals(2, tree.size());
        tree.insert(2);
        assertEquals(3, tree.size());
        tree.insert(2);
        assertEquals(3, tree.size());
        tree.insert(4);
        assertEquals(4, tree.size());
        tree.insert(4);
        assertEquals(4, tree.size());
    }

    @Test
    public void testDeleteNonExistantElement() {
        tree.delete(0);
        assertEquals(0, tree.size());
    }

    @Test
    public void testDeleteElementOneWithThreeElements() {
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.delete(1);
        assertEquals(2, tree.size());
    }

    @Test
    public void testDeleteElementTwoWithThreeElements() {
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.delete(1);
        assertEquals(2, tree.size());
    }

    @Test
    public void testDeleteElementThreeWithThreeElements() {
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.delete(2);
        assertEquals(2, tree.size());
    }

    @Test
    public void testDeleteInvalidElementWithThreeElements() {
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.delete(0);
        assertEquals(3, tree.size());
    }

    @Test
    public void testDeleteSevenElementsHighestToLowest() {
        tree.insert(6);
        tree.insert(2);
        tree.insert(10);
        tree.insert(0);
        tree.insert(4);
        tree.insert(8);
        tree.insert(12);
        assertEquals(7, tree.size());
        for (int i = 12; i >= 0; i -= 2) {
            tree.delete(i);
        }
        assertTrue(tree.isEmpty());
    }

    @Test
    public void testDeleteSevenElementsLowestToHighest() {
        tree.insert(6);
        tree.insert(2);
        tree.insert(10);
        tree.insert(0);
        tree.insert(4);
        tree.insert(8);
        tree.insert(12);
        assertEquals(7, tree.size());
        for (int i = 0; i <= 12; i += 2) {
            tree.delete(i);
        }
        assertTrue(tree.isEmpty());
    }

    @Test
    public void testDeleteSevenElementsStartingFromMiddle() {
        tree.insert(6);
        tree.insert(2);
        tree.insert(10);
        tree.insert(0);
        tree.insert(4);
        tree.insert(8);
        tree.insert(12);
        assertEquals(7, tree.size());
        for (int i = 12; i >= 0; i -= 2) {
            tree.delete((i + 6) % 14);
        }
        assertTrue(tree.isEmpty());
    }

    @Test
    public void testDeleteInvalidElementsFromSevenElementTree() {
        tree.insert(6);
        tree.insert(2);
        tree.insert(10);
        tree.insert(0);
        tree.insert(4);
        tree.insert(8);
        tree.insert(12);
        assertEquals(7, tree.size());
        for (int i = -1; i <= 13; i += 2) {
          tree.delete(i);
        }
        assertEquals(7, tree.size());
        tree.delete(-50);
        assertEquals(7, tree.size());
        tree.delete(50);
        assertEquals(7, tree.size());
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

    @Test
    public void testContainsEmptyTree() {
        assertFalse(tree.contains(0));
    }

    @Test
    public void testContainsValidElementOnSingleElementTree() {
        tree.insert(1);
        assertTrue(tree.contains(1));
    }

    @Test
    public void testContainsInvalidElementOnSingleElementTree() {
        tree.insert(1);
        assertFalse(tree.contains(0));
    }

    @Test
    public void testContainsValidElementsOnSevenElementTree() {
        tree.insert(6);
        tree.insert(2);
        tree.insert(10);
        tree.insert(0);
        tree.insert(4);
        tree.insert(8);
        tree.insert(12);
        for (int i = 0; i <= 12; i += 2) {
            assertTrue(tree.contains(i));
        }
    }

    @Test
    public void testContainsInvalidElementsOnSevenElementTree() {
        tree.insert(6);
        tree.insert(2);
        tree.insert(10);
        tree.insert(0);
        tree.insert(4);
        tree.insert(8);
        tree.insert(12);
        for (int i = -1; i <= 13; i += 2) {
            assertFalse(tree.contains(i));
        }
    }
}
