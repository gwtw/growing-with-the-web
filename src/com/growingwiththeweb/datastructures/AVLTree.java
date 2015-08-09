package com.growingwiththeweb.datastructures;

/**
 * Generic implementation of an AVL tree.
 */
public class AVLTree<K extends Comparable<K>> implements BinarySearchTreeInterface<K> {

    /**
     * The height of a left or right child node that doesn't exist.
     */
    private static final int NULL_NODE_HEIGHT = -1;

    /**
     * The root of the tree.
     */
    private AVLTreeNode root;

    /**
     * The size of the tree.
     */
    private int size = 0;

    /**
     * Creates a new {@link AVLTree}.
     */
    public AVLTree() { }

    /**
     * Inserts a new node with a specific key into the tree.
     *
     * @param key The key being inserted.
     */
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
    private AVLTreeNode insert(K key, AVLTreeNode<K> root) {
        if (root == null) {
            return new AVLTreeNode(key);
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

        root.setHeight(Math.max(getNodeLeftHeight(root), getNodeRightHeight(root)) + 1);

        int balance = getBalance(root);

        if (balance == 2) {
            if (key.compareTo(root.getLeft().getKey()) < 0) {
                // Left left case
                root = rightRotate(root);
            } else {
                // Left right case
                root.setLeft(leftRotate(root.getLeft()));
                return rightRotate(root);
            }
        }

        if (balance == -2) {
            if (key.compareTo(root.getRight().getKey()) > 0) {
                // Right right case
                root = leftRotate(root);
            } else {
                // Right left case
                root.setRight(rightRotate(root.getRight()));
                return leftRotate(root);
            }
        }

        return root;
    }

    /**
     * Deletes a node with a specific key from the tree.
     *
     * @param key The key being deleted.
     */
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
    private AVLTreeNode delete(K key, AVLTreeNode<K> root) {
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

        root.setHeight(Math.max(getNodeLeftHeight(root), getNodeRightHeight(root)) + 1);
        int balance = getBalance(root);

        if (balance == 2) {
            // Left left case
            if (getBalance(root.getLeft()) >= 0) {
                return rightRotate(root);
            }
            // Left right case
            if (getBalance(root.getLeft()) < 0) {
                root.setLeft(leftRotate(root.getLeft()));
                return rightRotate(root);
            }
        }

        // Right right case
        if (balance == -2) {
            if (getBalance(root.getRight()) <= 0) {
                return leftRotate(root);
            }
            // Right left case
            if (getBalance(root.getRight()) > 0) {
                root.setRight(rightRotate(root.getRight()));
                return leftRotate(root);
            }
        }

        return root;
    }

    /**
     * Gets whether a node with a specific key is within the tree.
     *
     * @param key The key being searched for.
     * @return Whether a node with the key exists.
     */
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

        if (key.compareTo(root.getKey())> 0 ) {
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
        return minValueNode(root).getKey();
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

    /**
     * @return The size of the tree.
     */
    public int size() {
        return size;
    }

    /**
     * @return Whether the tree is empty (size = 0).
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Gets the difference in height between the left and the right child of a node.
     *
     * @param node The node to get the difference from.
     * @return The difference in height between the left and the right child of a node.
     */
    private static int getBalance(AVLTreeNode node) {
        if (node == null) {
            return 0;
        }
        return getNodeLeftHeight(node) - getNodeRightHeight(node);
    }

    /**
     * Performs a right rotate on a node.
     *
     *       b                          a
     *      / \                        / \
     *     a   e -> rotateRight(a) -> c   b
     *    / \                            / \
     *   c   d                          d   e
     *
     * @param a The node being rotated
     * @return The new root.
     */
    private static AVLTreeNode rightRotate(AVLTreeNode k2) {
        AVLTreeNode k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.setHeight(Math.max(getNodeLeftHeight(k2), getNodeRightHeight(k2)) + 1);
        k1.setHeight(Math.max(getNodeLeftHeight(k1), k2.getHeight()) + 1);
        return k1;
    }

    /**
     * Performs a left rotate on a node.
     *
     *     a                             b
     *    / \                           / \
     *   c   b   -> rotateLeft(a) ->   a   e
     *      / \                       / \
     *     d   e                     c   d
     *
     * @param a The node being rotated
     * @return The new root.
     */
    private static AVLTreeNode leftRotate(AVLTreeNode a) {
        AVLTreeNode b = a.getRight();
        a.setRight(b.getLeft());
        b.setLeft(a);
        a.setHeight(Math.max(getNodeLeftHeight(a), getNodeRightHeight(a)) + 1);
        b.setHeight(Math.max(getNodeRightHeight(b), a.getHeight()) + 1);
        return b;
    }

    /**
     * Convenience function to get the height of the left child of a node, returning
     * {@link NULL_NODE_HEIGHT} if the node is null.
     *
     * @param node The node to check.
     * @return The height of the left child, or {@link NULL_NODE_HEIGHT} if it doesn't exist.
     */
    private static int getNodeLeftHeight(AVLTreeNode node) {
        if (!node.leftExists()) {
            return NULL_NODE_HEIGHT;
        }
        return node.getLeft().getHeight();
    }

    /**
     * Convenience function to get the height of the right child of a node, returning
     * {@link NULL_NODE_HEIGHT} if the node is null.
     *
     * @param node The node to check.
     * @return The height of the right child, or {@link NULL_NODE_HEIGHT} if it doesn't exist.
     */
    private static int getNodeRightHeight(AVLTreeNode node) {
        if (!node.rightExists()) {
            return NULL_NODE_HEIGHT;
        }
        return node.getRight().getHeight();
    }
}
