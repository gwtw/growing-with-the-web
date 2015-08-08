package com.growingwiththeweb.datastructures;

/**
 * Generic implementation of a binary search tree.
 */
public class BinarySearchTree<K extends Comparable<K>> implements BinarySearchTreeInterface<K> {

    /**
     * The root node of the binary search tree.
     */
    private BinarySearchTreeNode<K> root;

    /**
     * The size of the binary search tree.
     */
    private int size;

    /**
     * Creates a new {@link BinarySearchTree}.
     */
    public BinarySearchTree() { }

    /**
     * Inserts a {@link BinarySearchTreeNode} with a specific key.
     *
     * @param key The key of the node being inserted.
     */
    public void insert(K key) {
        if (root == null) {
            root = new BinarySearchTreeNode<K>(key);
            size++;
            return;
        }

        insert(key, root);
    }

    /**
     * Inserts a {@link BinarySearchTreeNode} with a specific key.
     *
     * @param key The key of the node being inserted.
     * @param node The current tree being looked at.
     */
    private void insert(K key, BinarySearchTreeNode<K> node) {
        if (node == null) {
            node = new BinarySearchTreeNode(key);
            size++;
            return;
        }

        if (key.compareTo(node.getKey()) < 0) {
            if (node.leftExists()) {
                insert(key, node.getLeft());
            } else {
                node.setLeft(new BinarySearchTreeNode(key));
                size++;
            }
        }

        if (key.compareTo(node.getKey()) > 0) {
            if (node.rightExists()) {
                insert(key, node.getRight());
            } else {
                node.setRight(new BinarySearchTreeNode(key));
                size++;
            }
        }
    }

    /**
     * Deletes a {@link BinarySearchTreeNode} matching a specific key.
     *
     * @param key The key of the node being deleted.
     */
    public void delete(K key) {
        if (root == null) {
            return;
        }

        deleteInternal(key, root);
    }

    /**
     * Finds a {@link BinarySearchTreeNode} matching a specific key from the
     * tree and deletes it.
     *
     * @param key The key of the node being deleted.
     * @param node The current tree being looked at.
     */
    private void deleteInternal(K key, BinarySearchTreeNode<K> node) {
        if (key.compareTo(node.getKey()) < 0) {
            if (node.leftExists()) {
                deleteInternal(key, node.getLeft());
            }
            if (node.getLeft().isDeleted()) {
                node.setLeft(null);
            }
            return;
        }

        if (key.compareTo(node.getKey()) > 0) {
            if (node.rightExists()) {
                deleteInternal(key, node.getRight());
            }
            if (node.getRight().isDeleted()) {
                node.setRight(null);
            }
            return;
        }

        deleteInternal(node);
    }

    /**
     * Deletes a {@link BinarySearchTreeNode} from the tree.
     *
     * @param node The node to delete.
     */
    private void deleteInternal(BinarySearchTreeNode<K> node) {
        size--;
        // No children exist, mark this node as deleted
        if (!(node.leftExists() || node.rightExists())) {
            node.setDeleted(true);
            return;
        }

        // Only the left child exists, move the left node to this position
        if (node.leftExists() && !node.rightExists()) {
            node.setKey(node.getLeft().getKey());
            if (node.getLeft().rightExists()) {
                node.setRight(node.getLeft().getRight());
            }
            if (node.getLeft().leftExists()) {
                node.setLeft(node.getLeft().getLeft());
            } else {
                node.setLeft(null);
            }
            return;
        }

        // Only the right child exists, move the right node to this position
        if (node.rightExists() && !node.leftExists()) {
            node.setKey(node.getRight().getKey());
            if (node.getRight().leftExists()) {
                node.setLeft(node.getRight().getLeft());
            }
            if (node.getRight().rightExists()) {
                node.setRight(node.getRight().getRight());
            } else {
                node.setRight(null);
            }
            return;
        }

        // Both children exist, replace this node with with minimum node from
        // the right sub-tree
        K min = findMin(node.getRight());
        node.setKey(min);
    }

    /**
     * @return The size of the binary search tree.
     */
    public int size() {
        return size;
    }

    /**
     * Recursively finds the {@link BinarySearchTreeNode} with the smallest key.
     *
     * @param node The current tree being looked at.
     */
    private K findMin(BinarySearchTreeNode<K> node) {
        if (!node.leftExists()) {
            node.setDeleted(true);
            return node.getKey();
        }

        K min = findMin(node.getLeft());
        if (node.getLeft().isDeleted()) {
            node.setLeft(null);
        }
        return min;
    }

    /**
     * Determines whether a {@link BinarySearchTreeNode} matching a specific key
     * exists.
     *
     * @param key The key to search for.
     * @return Whether a node with the key exists.
     */
    public boolean contains(K key) {
        if (root == null) {
            return false;
        }

        return contains(key, root);
    }

    /**
     * Recursively determines whether a {@link BinarySearchTreeNode} matching a
     * specific key exists.
     *
     * @param key The key to search for.
     * @param node The current tree being looked at.
     * @return Whether a node with the key exists.
     */
    private boolean contains(K key, BinarySearchTreeNode<K> node) {
        if (key == node.getKey()) {
            return true;
        }

        if (key.compareTo(node.getKey()) < 0) {
            if (!node.leftExists()) {
                return false;
            }
            return contains(key, node.getLeft());
        }

        if (key.compareTo( node.getKey())> 0 ) {
            if (!node.rightExists()) {
                return false;
            }
            return contains(key, node.getRight());
        }

        return false;
    }

    /**
     * @return A string that textually describes the tree.
     */
    public String toString() {
        return root.toString();
    }
}
