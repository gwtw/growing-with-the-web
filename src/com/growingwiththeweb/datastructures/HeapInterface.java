package com.growingwiththeweb.datastructures;

public interface HeapInterface<K> {
    void insert(K item);
    K extractMin();
    K min();
    void clear();
    boolean isEmpty();
    int size();
}
