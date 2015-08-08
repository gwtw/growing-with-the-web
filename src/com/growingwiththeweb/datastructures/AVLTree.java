package com.growingwiththeweb.datastructures;

/**
 * Generic implementation of an AVL tree.
 */
public class AVLTree<K extends Comparable<K>> {

    private AVLTreeNode root;
    private int size = 0;

    public AVLTree() { }

    public void insert(K key) {
        root = insert(key, root);
        size++;
    }

    public void delete(K key) {
    }

    public boolean contains(K key) {
        return false;
    }

    public K findMinimum() {
        return null;
    }

    public K findMaximum() {
        return null;
    }

    public int getSize() {
        return size;
    }

    private void balance() {

    }

    private AVLTreeNode insert(K key, AVLTreeNode<K> root) {
        if (root == null) {
            root = new AVLTreeNode(key);
        } else if (key.compareTo(root.getKey()) < 0) {
            root.setLeft(insert(key, root.getLeft()));
            if (getNodeLeftHeight(root) - getNodeRightHeight(root) == 2) {
                if (key.compareTo(root.getLeft().getKey()) < 0) {
                    root = rotateWithLeftChild(root);
                } else {
                    root = doubleWithLeftChild(root);
                }
            }
        } else if (key.compareTo(root.getKey()) > 0) {
            root.setRight(insert(key, root.getRight()));
            if (getNodeRightHeight(root) - getNodeLeftHeight(root) == 2) {
                if (key.compareTo(root.getRight().getKey()) > 0) {
                    root = rotateWithRightChild(root);
                } else {
                    root = doubleWithRightChild(root);
                }
            }
        } else {
            // It's a duplicate so insertion failed, decrement size to make up for it
            size--;
        }
        root.setHeight(Math.max(getNodeLeftHeight(root), getNodeRightHeight(root)) + 1);
        return root;
    }

    private static AVLTreeNode rotateWithLeftChild(AVLTreeNode k2)
    {
        AVLTreeNode k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.setHeight(Math.max(getNodeLeftHeight(k2), getNodeRightHeight(k2)) + 1);
        k1.setHeight(Math.max(getNodeLeftHeight(k1), k2.getHeight()) + 1);
        return k1;
    }

    private static AVLTreeNode rotateWithRightChild(AVLTreeNode k1)
    {
        AVLTreeNode k2 = k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        k1.setHeight(Math.max(getNodeLeftHeight(k1), getNodeRightHeight(k1)) + 1);
        k2.setHeight(Math.max(getNodeRightHeight(k2), k1.getHeight()) + 1);
        return k2;
    }

    private static AVLTreeNode doubleWithLeftChild(AVLTreeNode k3)
    {
        k3.setLeft(rotateWithRightChild(k3.getLeft()));
        return rotateWithLeftChild(k3);
    }

    private static AVLTreeNode doubleWithRightChild(AVLTreeNode k1)
    {
        k1.setRight(rotateWithLeftChild(k1.getRight()));
        return rotateWithRightChild(k1);
    }

    private static int getNodeLeftHeight(AVLTreeNode node) {
        if (node.getLeft() == null) {
            return -1;
        }
        return node.getLeft().getHeight();
    }

    private static int getNodeRightHeight(AVLTreeNode node) {
        if (node.getRight() == null) {
            return -1;
        }
        return node.getRight().getHeight();
    }
}
