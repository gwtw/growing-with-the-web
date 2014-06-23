package dataStructures;

import dataStructures.binarySearchTree.BinarySearchTreeNode;
import java.util.ArrayList;

public class BinarySearchTree<K extends Comparable<K>> {
    private BinarySearchTreeNode<K> root;

    public BinarySearchTree() { }

    public void insert(K key) {
        if (root == null) {
            root = new BinarySearchTreeNode<K>(key);
            return;
        }

        insert(key, root);
    }

    private void insert(K key, BinarySearchTreeNode<K> node) {
        if (node == null) {
            node = new BinarySearchTreeNode(key);
            return;
        }

        if (key.compareTo(node.getKey()) < 0) {
            if (node.leftExists())
                insert(key, node.getLeft());
            else
                node.setLeft(new BinarySearchTreeNode(key));
        }

        if (key.compareTo(node.getKey()) > 0) {
            if (node.rightExists())
                insert(key, node.getRight());
            else
                node.setRight(new BinarySearchTreeNode(key));
        }
    }

    public void delete( K key) {
        if (root == null)
            return;

        delete(key, root);
    }

    private void delete( K key, BinarySearchTreeNode<K> node) {
        if (key.compareTo(node.getKey()) < 0) {
            if (node.leftExists())
                delete(key, node.getLeft());
            if (node.getLeft().isDeleted())
                node.setLeft(null);
            return;
        }

        if (key.compareTo(node.getKey()) > 0) {
            if (node.rightExists())
                delete(key, node.getRight());
            if (node.getRight().isDeleted())
                node.setRight(null);
            return;
        }

        delete(node);
    }

    private void delete(BinarySearchTreeNode<K> node) {
        if (!(node.leftExists() || node.rightExists())) {
            node.setDeleted(true);
            return;
        }

        if (node.leftExists() && !node.rightExists()) {
            node.setKey(node.getLeft().getKey());
            if (node.getLeft().rightExists())
                node.setRight(node.getLeft().getRight());
            if (node.getLeft().leftExists())
                node.setLeft(node.getLeft().getLeft());
            else
                node.setLeft(null);
            return;
        }

        if (node.rightExists() && !node.leftExists()) {
            node.setKey(node.getRight().getKey());
            if (node.getRight().leftExists())
                node.setLeft(node.getLeft().getLeft());
            if (node.getRight().rightExists())
                node.setRight(node.getLeft().getRight());
            else
                node.setRight(null);
            return;
        }

        // both exist, replace with minimum from right sub-tree
        K min = findMin(node.getRight());
        node.setKey(min);
    }

    private K findMin(BinarySearchTreeNode<K> node) {
        if (!node.leftExists()) {
            node.setDeleted(true);
            return node.getKey();
        }

        K min = findMin(node.getLeft());
        if (node.getLeft().isDeleted())
            node.setLeft(null);
        return min;
    }

    public boolean search(K key) {
        if (root == null)
            return false;

        return search(key, root);
    }

    private boolean search( K key, BinarySearchTreeNode<K> node) {
        if (key == node.getKey())
            return true;

        if (key.compareTo(node.getKey()) < 0) {
            if (!node.leftExists())
                return false;
            return search(key, node.getLeft());
        }

        if (key.compareTo( node.getKey())> 0 ) {
            if (!node.rightExists())
                return false;
            return search(key, node.getRight());
        }

        return false;
    }

    public String toString() {
        return root.toString();
    }
}
