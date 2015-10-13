package com.growingwiththeweb.algorithms.interviewquestions.checkifabinarytreeisbalanced;

import java.lang.IllegalArgumentException;

public class Solution {
    /**
     * Determines whether a binary tree is balanced.
     *
     * @param {BinaryTreeNode} root The root of the tree.
     * @returns Whether the tree is balanced.
     */
    public static boolean isBinaryTreeBalanced(BinaryTreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException(
                    "The tree root must be non null");
        }
        return maxDepth(root) - minDepth(root) <= 1;
    }

    /**
     * Determines the minimum depth of a binary tree node.
     *
     * @param node The node to check.
     * @return The minimum depth of a binary tree node.
     */
    private static int minDepth(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.min(minDepth(node.left), minDepth(node.right));
    }

    /**
     * Determines the maximum depth of a binary tree node.
     *
     * @param node The node to check.
     * @return The maximum depth of a binary tree node.
     */
    private static int maxDepth(BinaryTreeNode node) {
      if (node == null) {
          return 0;
      }
      return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
}
