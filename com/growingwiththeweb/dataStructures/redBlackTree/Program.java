package com.growingwiththeweb.dataStructures.redBlackTree;

public class Program {
	public static void main(String[] args) {
		RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
		tree.insert(8);
		System.out.println(tree.toString());
		 tree.insert(7);
		System.out.println(tree.toString());
		tree.insert(6);
		System.out.println(tree.toString());
		tree.insert(3);
		System.out.println(tree.toString());
		tree.insert(5);
		System.out.println(tree.toString());
		tree.insert(2);
		System.out.println(tree.toString());
		tree.insert(1);
		System.out.println(tree.toString());
		tree.insert(4);
		System.out.println(tree.toString());
		tree.insert(10);
		System.out.println(tree.toString());
		tree.insert(85);
		System.out.println(tree.toString());
		tree.insert(15);
		System.out.println(tree.toString());
		tree.insert(70);
		System.out.println(tree.toString());
		tree.insert(20);
		System.out.println(tree.toString());
		tree.insert(60);
		System.out.println(tree.toString());
		tree.insert(30);
		System.out.println(tree.toString());
		tree.insert(50);
		System.out.println(tree.toString());
		tree.insert(65);
		System.out.println(tree.toString());
		tree.insert(80);
		System.out.println(tree.toString());
		tree.insert(90);
		System.out.println(tree.toString());
		tree.insert(40);
		System.out.println(tree.toString());
		tree.insert(5);
		System.out.println(tree.toString());
		tree.insert(55);
		System.out.println(tree.toString());

		tree.delete(60);
		System.out.println(tree.toString());
	}

}
