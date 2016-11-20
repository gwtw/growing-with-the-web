package com.growingwiththeweb.datastructures;

/**
 * Generic implementation of an AVL tree node.
 */
public class AVLTreeNode<K extends Comparable<K>> implements Comparable<AVLTreeNode<K>> {
    /**
     * The height of a left or right child node that doesn't exist.
     */
    private static final int NULL_NODE_HEIGHT = -1;

    /**
     * The left child node.
     */
    private AVLTreeNode<K> left;

    /**
     * The right child node.
     */
    private AVLTreeNode<K> right;

    /**
     * The key of the node.
     */
    private K key;

    /**
     * The height of the node.
     */
    private int height;

    /**
     * Creates a new {@link AVLTreeNode}.
     *
     * @param key The key of the new node.
     */
    public AVLTreeNode(K key) {
        this.key = key;
    }

    /**
     * @return Whether the node has a left child.
     */
    public boolean leftExists() {
        return left != null;
    }

    /**
     * @return Whether the node has a right child.
     */
    public boolean rightExists() {
        return right != null;
    }

    /**
     * @return The key of this node.
     */
    public K getKey() {
        return key;
    }

    /**
     * Sets the key of this node.
     *
     * @param key The new key.
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * @return The left child node.
     */
    public AVLTreeNode<K> getLeft() {
        return left;
    }

    /**
     * Sets the left child node.
     *
     * @param left The new left child node.
     */
    public void setLeft(AVLTreeNode<K> left) {
        this.left = left;
    }

    /**
     * @return The right child node.
     */
    public AVLTreeNode<K> getRight() {
        return right;
    }

    /**
     * Sets the right child node.
     *
     * @param right The new right child node.
     */
    public void setRight(AVLTreeNode<K> right) {
        this.right = right;
    }

    /**
     * @return The height of the node.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the height of the node.
     *
     * @param height The new height of the node.
     */
    public void setHeight(int height) {
        this.height = height;
    }


    /**
     * Performs a right rotate on this node.
     *
     *       b                           a
     *      / \                         / \
     *     a   e -> b.rotateRight() -> c   b
     *    / \                             / \
     *   c   d                           d   e
     *
     * @return The root of the sub-tree; the node where this node used to be.
     */
    public AVLTreeNode<K> rotateRight() {
        AVLTreeNode<K> other = getLeft();
        setLeft(other.getRight());
        other.setRight(this);
        setHeight(Math.max(this.getLeftHeight(), this.getRightHeight()) + 1);
        other.setHeight(Math.max(other.getLeftHeight(), this.getHeight()) + 1);
        return other;
    }

    /**
     * Performs a left rotate on this node.
     *
     *     a                              b
     *    / \                            / \
     *   c   b   -> a.rotateLeft() ->   a   e
     *      / \                        / \
     *     d   e                      c   d
     *
     * @return The root of the sub-tree; the node where this node used to be.
     */
    public AVLTreeNode<K> rotateLeft() {
        AVLTreeNode<K> other = getRight();
        setRight(other.getLeft());
        other.setLeft(this);
        setHeight(Math.max(this.getLeftHeight(), this.getRightHeight()) + 1);
        other.setHeight(Math.max(other.getRightHeight(), this.getHeight()) + 1);
        return other;
    }

    /**
     * Convenience function to get the height of the left child of the node, returning
     * {@link NULL_NODE_HEIGHT} if the node is null.
     *
     * @return The height of the left child, or {@link NULL_NODE_HEIGHT} if it doesn't exist.
     */
    public int getLeftHeight() {
        if (!leftExists()) {
            return NULL_NODE_HEIGHT;
        }
        return getLeft().getHeight();
    }

    /**
     * Convenience function to get the height of the right child of the node, returning
     * {@link NULL_NODE_HEIGHT} if the node is null.
     *
     * @return The height of the right child, or {@link NULL_NODE_HEIGHT} if it doesn't exist.
     */
    public int getRightHeight() {
        if (!rightExists()) {
            return NULL_NODE_HEIGHT;
        }
        return getRight().getHeight();
    }

    /** {@inheritDoc} */
    @Override
    public int compareTo(AVLTreeNode<K> o) {
        return key.compareTo(o.key);
    }
}
