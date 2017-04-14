package com.growingwiththeweb.datastructures;

/**
 * Generic implementation of an AVL tree.
 */
public class AVLTree<K extends Comparable<K>> implements BinarySearchTreeInterface<K> {
    /**
     * The root of the tree.
     */
    private AVLTreeNode<K> root;

    /**
     * The size of the tree.
     */
    private int size = 0;

    /**
     * Creates a new {@link AVLTree}.
     */
    public AVLTree() { }

    /** {@inheritDoc} */
    public void insert(K key) {
        root = insert(key, root);
        size++;
    }

    /**
     * Inserts a new node with a specific key into the tree.
     *
     * @param key The key being inserted.
     * @param root The root of the tree to insert in.
     * @return The new tree root.
     */
    private AVLTreeNode<K> insert(K key, AVLTreeNode<K> root) {
        // Perform regular BST insertion
        if (root == null) {
            return new AVLTreeNode<K>(key);
        }

        if (key.compareTo(root.getKey()) < 0) {
            root.setLeft(insert(key, root.getLeft()));
        } else if (key.compareTo(root.getKey()) > 0) {
            root.setRight(insert(key, root.getRight()));
        } else {
            // It's a duplicate so insertion failed, decrement size to make up for it
            size--;
            return root;
        }

        // Update height and rebalance tree
        root.setHeight(Math.max(root.getLeftHeight(), root.getRightHeight()) + 1);
        BalanceState balanceState = getBalanceState(root);

        if (balanceState == BalanceState.UNBALANCED_LEFT) {
            if (key.compareTo(root.getLeft().getKey()) < 0) {
                // Left left case
                root = root.rotateRight();
            } else {
                // Left right case
                root.setLeft(root.getLeft().rotateLeft());
                return root.rotateRight();
            }
        }

        if (balanceState == BalanceState.UNBALANCED_RIGHT) {
            if (key.compareTo(root.getRight().getKey()) > 0) {
                // Right right case
                root = root.rotateLeft();
            } else {
                // Right left case
                root.setRight(root.getRight().rotateRight());
                return root.rotateLeft();
            }
        }

        return root;
    }

    /** {@inheritDoc} */
    public void delete(K key) {
        root = delete(key, root);
        size--;
    }

    /**
     * Deletes a node with a specific key from the tree.
     *
     * @param key The key being deleted.
     * @param root The root of the tree to delete from.
     * @return The new tree root.
     */
    private AVLTreeNode<K> delete(K key, AVLTreeNode<K> root) {
        // Perform regular BST deletion
        if (root == null) {
            size++;
            return root;
        }

        if (key.compareTo(root.getKey()) < 0) {
            // The key to be deleted is in the left sub-tree
            root.setLeft(delete(key, root.getLeft()));
        } else if (key.compareTo(root.getKey()) > 0) {
            // The key to be deleted is in the right sub-tree
            root.setRight(delete(key, root.getRight()));
        } else {
            // root is the node to be deleted
            if (!root.leftExists() && !root.rightExists()) {
                root = null;
            } else if (!root.leftExists() && root.rightExists()) {
                root = root.getRight();
            } else if (root.leftExists() && !root.rightExists()) {
                root = root.getLeft();
            } else {
                // Node has 2 children, get the in-order successor
                AVLTreeNode<K> inOrderSuccessor = minValueNode(root.getRight());
                root.setKey(inOrderSuccessor.getKey());
                root.setRight(delete(inOrderSuccessor.getKey(), root.getRight()));
            }
        }

        if (root == null) {
            return root;
        }

        // Update height and rebalance tree
        root.setHeight(Math.max(root.getLeftHeight(), root.getRightHeight()) + 1);
        BalanceState balanceState = getBalanceState(root);

        if (balanceState == BalanceState.UNBALANCED_LEFT) {
            // Left left case
            if (getBalanceState(root.getLeft()) == BalanceState.BALANCED ||
                    getBalanceState(root.getLeft()) == BalanceState.SLIGHTLY_UNBALANCED_LEFT) {
                return root.rotateRight();
            }
            // Left right case
            if (getBalanceState(root.getLeft()) == BalanceState.SLIGHTLY_UNBALANCED_RIGHT) {
                root.setLeft(root.getLeft().rotateLeft());
                return root.rotateRight();
            }
        }

        // Right right case
        if (balanceState == BalanceState.UNBALANCED_RIGHT) {
            if (getBalanceState(root.getLeft()) == BalanceState.BALANCED ||
                    getBalanceState(root.getLeft()) == BalanceState.SLIGHTLY_UNBALANCED_RIGHT) {
                return root.rotateLeft();
            }
            // Right left case
            if (getBalanceState(root.getLeft()) == BalanceState.SLIGHTLY_UNBALANCED_LEFT) {
                root.setRight(root.getRight().rotateRight());
                return root.rotateLeft();
            }
        }

        return root;
    }

    /** {@inheritDoc} */
    public boolean contains(K key) {
        if (root == null) {
            return false;
        }

        return contains(key, root);
    }

    /**
     * Gets whether a node with a specific key is within the tree.
     *
     * @param key The key being searched for.
     * @param root The root of the tree to search in.
     * @return Whether a node with the key exists.
     */
    private boolean contains(K key, AVLTreeNode<K> root) {
        if (key == root.getKey()) {
            return true;
        }

        if (key.compareTo(root.getKey()) < 0) {
            if (!root.leftExists()) {
                return false;
            }
            return contains(key, root.getLeft());
        }

        if (key.compareTo(root.getKey()) > 0) {
            if (!root.rightExists()) {
                return false;
            }
            return contains(key, root.getRight());
        }

        return false;
    }

    /**
     * @return The minimum key in the tree.
     */
    public K findMinimum() {
        return minValueNode(root).getKey();
    }

    /**
     * Gets the minimum value node, rooted in a particular node.
     *
     * @param root The node to search.
     * @return The node with the minimum key in the tree.
     */
    private AVLTreeNode<K> minValueNode(AVLTreeNode<K> root) {
        AVLTreeNode<K> current = root;
        while (current.leftExists()) {
            current = current.getLeft();
        }
        return current;
    }

    /**
     * @return The maximum key in the tree.
     */
    public K findMaximum() {
        return maxValueNode(root).getKey();
    }

    /**
     * Gets the maximum value node, rooted in a particular node.
     *
     * @param root The node to search.
     * @return The node with the maximum key in the tree.
     */
    private AVLTreeNode<K> maxValueNode(AVLTreeNode<K> root) {
        AVLTreeNode<K> current = root;
        while (current.rightExists()) {
            current = current.getRight();
        }
        return current;
    }

    /** {@inheritDoc} */
    public int size() {
        return size;
    }

    /** {@inheritDoc} */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Gets the balance state of a node, indicating whether the left or right sub-trees are
     * unbalanced.
     *
     * @param node The node to get the difference from.
     * @return The {@link BalanceState} of the node.
     */
    private BalanceState getBalanceState(AVLTreeNode<K> node) {
        if (node == null) {
            return BalanceState.BALANCED;
        }
        int heightDifference = node.getLeftHeight() - node.getRightHeight();
        switch (heightDifference) {
            case -2: return BalanceState.UNBALANCED_RIGHT;
            case -1: return BalanceState.SLIGHTLY_UNBALANCED_RIGHT;
            case 1: return BalanceState.SLIGHTLY_UNBALANCED_LEFT;
            case 2: return BalanceState.UNBALANCED_LEFT;
        }
        return BalanceState.BALANCED;
    }

    /**
     * Represents how balanced a node's left and right children are.
     */
    private enum BalanceState {
        UNBALANCED_RIGHT,
        SLIGHTLY_UNBALANCED_RIGHT,
        BALANCED,
        SLIGHTLY_UNBALANCED_LEFT,
        UNBALANCED_LEFT
    }
}
