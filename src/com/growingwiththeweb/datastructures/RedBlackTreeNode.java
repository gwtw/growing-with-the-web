package com.growingwiththeweb.datastructures;

public class RedBlackTreeNode<T extends Comparable<T>> implements Comparable<RedBlackTreeNode<T>> {

    private final String nullNodeString = "_B";
    private RedBlackTreeNode left;
    private RedBlackTreeNode right;
    private RedBlackTreeNode parent;

    private T key;
    private boolean isNilNode;
    private Color color;

    /**
     * Creates a new {@link RedBlackTreeNode}.
     *
     * @param key The key of the new node.
     * @param parent The parent of the new node.
     */
    public RedBlackTreeNode(T key, RedBlackTreeNode parent) {
        this.key = key;
        this.parent = parent;
        this.color = Color.RED;
        this.setNilNode(false);
    }

    /**
     * Creates a new nil (black) {@link RedBlackTreeNode}.
     *
     * @param parent The parent of the new node.
     */
    private RedBlackTreeNode(RedBlackTreeNode parent) {
        this.parent = parent;
        this.color = Color.BLACK;
        this.setNilNode(true);
    }

    /**
     * @return A string that textually describes the node.
     */
    @Override
    public String toString() {
        if (isNilNode) {
            return nullNodeString;
        }
        return key + getColorCode() + " : { " +
                (leftExists() ? left.toString() : nullNodeString) + " , " +
                (rightExists() ? right.toString() : nullNodeString) + " }";
    }

    /**
     * @return The color code for the node, either red or black.
     */
    private String getColorCode() {
        if (color == Color.BLACK) {
            return "B";
        }
        return "R";
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
     * @return The node's key.
     */
    public T getKey() {
        return key;
    }

    /**
     * Sets the node's key.
     *
     * @param key The new key.
     */
    public void setKey(T key) {
        this.key = key;
    }

    public RedBlackTreeNode getLeft() {
        // Create nil leaf nodes lazily
        if (left == null) {
            left = new RedBlackTreeNode(this);
        }
        return left;
    }

    public void setLeft(RedBlackTreeNode left) {
        this.left = left;
    }

    public RedBlackTreeNode getRight() {
        // Create nil leaf nodes lazily
        if (right == null) {
            right = new RedBlackTreeNode(this);
        }
        return right;
    }

    public void setRight(RedBlackTreeNode right) {
        this.right = right;
    }

    public RedBlackTreeNode getParent() {
        return parent;
    }

    public RedBlackTreeNode getGrandparent() {
        if (parent != null && parent.getParent() != null) {
            return parent.getParent();
        }
        return null;
    }

    public void setParent(RedBlackTreeNode parent) {
        this.parent = parent;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isNilNode() {
        return isNilNode;
    }

    public final void setNilNode(boolean isNilNode) {
        this.isNilNode = isNilNode;
    }

    @Override
    public int compareTo(RedBlackTreeNode<T> o) {
        return this.key.compareTo(o.getKey());
    }

    public enum Color {
        BLACK,
        RED
    }

}
