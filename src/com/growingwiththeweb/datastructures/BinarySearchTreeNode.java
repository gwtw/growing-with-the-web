package com.growingwiththeweb.datastructures;

public class BinarySearchTreeNode<K extends Comparable<K>> implements Comparable<BinarySearchTreeNode<K>> {

    private final String nullNodeString = "_";
    private BinarySearchTreeNode<K> left;
    private BinarySearchTreeNode<K> right;

    private K key;
    private boolean isDeleted = false;

    /**
     * Creates a new {@link BinarySearchTreeNode}.
     *
     * @param key The key of the new node.
     */
    public BinarySearchTreeNode(K key) {
        this.key = key;
    }

    /**
     * @return A string that textually describes the tree rooted at this node.
     */
    @Override
    public String toString() {
        return key + " : " + ((leftExists() || rightExists()) ? ("{ " +
                (leftExists() ? left.toString() : nullNodeString) + " , " +
                (rightExists() ? right.toString() : nullNodeString) + " }") : "<leaf>");
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
    public BinarySearchTreeNode<K> getLeft() {
        return left;
    }

    /**
     * Sets the left child node.
     *
     * @param left The new left child node.
     */
    public void setLeft(BinarySearchTreeNode<K> left) {
        this.left = left;
    }

    /**
     * @return The right child node.
     */
    public BinarySearchTreeNode<K> getRight() {
        return right;
    }

    /**
     * Sets the right child node.
     *
     * @param right The new right child node.
     */
    public void setRight(BinarySearchTreeNode<K> right) {
        this.right = right;
    }

    /**
     * @return Whether the node has been deleted.
     */
    public boolean isDeleted() {
        return isDeleted;
    }

    /**
     * Sets whether the node has been soft-deleted, allowing a node to be
     * be excluded from searching without requiring a reference to its parent.
     *
     * @param isDeleted Whether the node is deleted
     */
    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public int compareTo(BinarySearchTreeNode<K> o) {
        return key.compareTo(o.key);
    }
}
