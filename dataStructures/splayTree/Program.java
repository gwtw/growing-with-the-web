package dataStructures.splayTree;

import dataStructures.SplayTree;

public class Program {
	public static void main(String[] args) {
		SplayTree<Integer> splayTree = new SplayTree<Integer>();

		splayTree.insert(1);
		splayTree.insert(2);
		splayTree.insert(3);
		splayTree.insert(4);
		splayTree.insert(5);
		splayTree.toString();
	}
}
