package com.growingwiththeweb.datastructures;

/**
 * An interface for data structures that support binary search tree operations.
 */
public interface BinarySearchTreeInterface<K> {
    /**
     * Inserts a new node with a specific key into the tree.
     *
     * @param key The key being inserted.
     */
    void insert(K key);

    /**
     * Deletes a node with a specific key from the tree.
     *
     * @param key The key being deleted.
     */
    void delete(K key);

    /**
     * Gets whether a node with a specific key is within the tree.
     *
     * @param key The key being searched for.
     * @return Whether a node with the key exists.
     */
    boolean contains(K key);

    /**
     * @return The size of the tree.
     */
    int size();

    /**
     * @return Whether the tree is empty; the size of the tree is 0).
     */
    boolean isEmpty();
}
