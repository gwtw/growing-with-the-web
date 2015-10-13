package com.growingwiththeweb.algorithms.interviewquestions.checkifabinarytreeisbalanced;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.IllegalArgumentException;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class SolutionTest {
    @Test(expected=IllegalArgumentException.class)
    public void testNullInput() {
        Solution.isBinaryTreeBalanced(null);
    }

    @Test
    public void testSingleElementTree() {
        assertTrue(Solution.isBinaryTreeBalanced(new BinaryTreeNode(null, null, null)));
    }

    @Test
    public void testLeftHeavyTwoElementTree() {
        BinaryTreeNode tree = new BinaryTreeNode(null,
                new BinaryTreeNode(null, null, null),
                null);
        assertTrue(Solution.isBinaryTreeBalanced(tree));
    }

    @Test
    public void testRightHeavyTwoElementTree() {
        BinaryTreeNode tree = new BinaryTreeNode(null,
                null,
                new BinaryTreeNode(null, null, null));
        assertTrue(Solution.isBinaryTreeBalanced(tree));
    }

    @Test
    public void testLeftHeavyThreeElementTree() {
        BinaryTreeNode tree = new BinaryTreeNode(null,
                new BinaryTreeNode(null,
                        new BinaryTreeNode(null, null, null),
                        null),
                null);
        assertFalse(Solution.isBinaryTreeBalanced(tree));
    }

    @Test
    public void testBalancedThreeElementTree() {
        BinaryTreeNode tree = new BinaryTreeNode(null,
                new BinaryTreeNode(null, null, null),
                new BinaryTreeNode(null, null, null));
        assertTrue(Solution.isBinaryTreeBalanced(tree));
    }

    @Test
    public void testRightHeavyThreeElementTree() {
        BinaryTreeNode tree = new BinaryTreeNode(null,
                null,
                new BinaryTreeNode(null,
                        null,
                        new BinaryTreeNode(null, null, null)));
        assertFalse(Solution.isBinaryTreeBalanced(tree));
    }
}
