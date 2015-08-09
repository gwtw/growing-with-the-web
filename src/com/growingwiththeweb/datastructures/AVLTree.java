package com.growingwiththeweb.datastructures;

/**
 * Generic implementation of an AVL tree.
 */
public class AVLTree<K extends Comparable<K>> implements BinarySearchTreeInterface<K> {

    private AVLTreeNode root;
    private int size = 0;

    public AVLTree() { }

    public void insert(K key) {
        root = insert(key, root);
        size++;
    }

    public void delete(K key) {
        root = delete(key, root);
        size--;
    }

    public boolean contains(K key) {
        if (root == null) {
            return false;
        }

        return contains(key, root);
    }

    private boolean contains(K key, AVLTreeNode<K> node) {
        if (key == node.getKey()) {
            return true;
        }

        if (key.compareTo(node.getKey()) < 0) {
            if (!node.leftExists()) {
                return false;
            }
            return contains(key, node.getLeft());
        }

        if (key.compareTo(node.getKey())> 0 ) {
            if (!node.rightExists()) {
                return false;
            }
            return contains(key, node.getRight());
        }

        return false;
    }

    public K findMinimum() {
        return minValueNode(root).getKey();
    }

    public K findMaximum() {
        return minValueNode(root).getKey();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private AVLTreeNode insert(K key, AVLTreeNode<K> root) {
        if (root == null) {
            root = new AVLTreeNode(key);
        } else if (key.compareTo(root.getKey()) < 0) {
            root.setLeft(insert(key, root.getLeft()));
            if (getNodeLeftHeight(root) - getNodeRightHeight(root) == 2) {
                if (key.compareTo(root.getLeft().getKey()) < 0) {
                    // Left left case
                    root = rightRotate(root);
                } else {
                    // Left right case
                    root = doubleWithLeftChild(root);
                }
            }
        } else if (key.compareTo(root.getKey()) > 0) {
            root.setRight(insert(key, root.getRight()));
            if (getNodeRightHeight(root) - getNodeLeftHeight(root) == 2) {
                if (key.compareTo(root.getRight().getKey()) > 0) {
                    // Right right case
                    root = leftRotate(root);
                } else {
                    // Right left case
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
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
            } else if (root.getLeft() == null && root.getRight() != null) {
                root = root.getRight();
            } else if (root.getLeft() != null && root.getRight() == null) {
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

        // Left left case
        if (balance == 2 && getBalance(root.getLeft()) >= 0) {
            return rightRotate(root);
        }

        // Left right case
        if (balance == 2 && getBalance(root.getLeft()) < 0) {
            root.setLeft(leftRotate(root.getLeft()));
            return rightRotate(root);
        }

        // Right right case
        if (balance == -2 && getBalance(root.getRight()) <= 0) {
            return leftRotate(root);
        }

        // Right left case
        if (balance == -2 && getBalance(root.getRight()) > 0) {
            root.setRight(rightRotate(root.getRight()));
            return leftRotate(root);
        }

        return root;
    }

    private AVLTreeNode<K> minValueNode(AVLTreeNode<K> node) {
        AVLTreeNode<K> current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    private AVLTreeNode<K> maxValueNode(AVLTreeNode<K> node) {
        AVLTreeNode<K> current = node;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current;
    }

    private static int getBalance(AVLTreeNode node) {
        if (node == null) {
            return 0;
        }
        return getNodeLeftHeight(node) - getNodeRightHeight(node);
    }

    private static AVLTreeNode rightRotate(AVLTreeNode k2)
    {
        AVLTreeNode k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.setHeight(Math.max(getNodeLeftHeight(k2), getNodeRightHeight(k2)) + 1);
        k1.setHeight(Math.max(getNodeLeftHeight(k1), k2.getHeight()) + 1);
        return k1;
    }

    private static AVLTreeNode leftRotate(AVLTreeNode k1)
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
        k3.setLeft(leftRotate(k3.getLeft()));
        return rightRotate(k3);
    }

    private static AVLTreeNode doubleWithRightChild(AVLTreeNode k1)
    {
        k1.setRight(rightRotate(k1.getRight()));
        return leftRotate(k1);
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
