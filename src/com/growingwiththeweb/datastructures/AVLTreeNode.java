package com.growingwiththeweb.datastructures;

/**
 * Generic implementation of a binary search tree node.
 */
public class AVLTreeNode<K extends Comparable<K>> implements Comparable<AVLTreeNode<K>> {

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
     * Creates a new {@link BinarySearchTreeNode}.
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

    @Override
    public int compareTo(AVLTreeNode<K> o) {
        return key.compareTo(o.key);
    }
}
