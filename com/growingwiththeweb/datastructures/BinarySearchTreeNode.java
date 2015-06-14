package com.growingwiththeweb.datastructures;

public class BinarySearchTreeNode<K extends Comparable<K>> implements Comparable<BinarySearchTreeNode<K>> {

    private final String nullNodeString = "_";
    private BinarySearchTreeNode<K> left;
    private BinarySearchTreeNode<K> right;

    private K key;
    private boolean isDeleted = false;

    public BinarySearchTreeNode(K key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key + " : " + ((leftExists() || rightExists()) ? ("{ " +
                (leftExists() ? left.toString() : nullNodeString) + " , " +
                (rightExists() ? right.toString() : nullNodeString) + " }") : "<leaf>");
    }

    public boolean leftExists() {
        return left != null;
    }

    public boolean rightExists() {
        return right != null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public BinarySearchTreeNode<K> getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTreeNode<K> left) {
        this.left = left;
    }

    public BinarySearchTreeNode<K> getRight() {
        return right;
    }

    public void setRight(BinarySearchTreeNode<K> right) {
        this.right = right;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public int compareTo(BinarySearchTreeNode<K> o) {
        return key.compareTo(o.key);
    }

}
