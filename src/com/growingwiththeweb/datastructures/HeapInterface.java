package com.growingwiththeweb.datastructures;

public interface HeapInterface<T> {
    void insert(T item);
    T extractMin();
    T min();
    boolean isEmpty();
    int size();
}
