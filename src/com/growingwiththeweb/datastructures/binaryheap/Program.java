package com.growingwiththeweb.datastructures.binaryheap;

import com.growingwiththeweb.datastructures.BinaryHeap;

public class Program {
	public static void main(String[] args) {
		BinaryHeap<Integer> heap = new BinaryHeap<Integer>();
		heap.insert(4);
		heap.insert(1);
		heap.insert(8);
		heap.insert(6);
		heap.insert(9);
		heap.insert(5);
		heap.insert(10);
		heap.insert(2);
		heap.insert(3);
		heap.insert(7);

		for (int i = 1; i <= 10; i++) {
			assert heap.extractMin() == i;
		}
		assert heap.isEmpty();

		System.out.println("Tests passed");
	}
}
