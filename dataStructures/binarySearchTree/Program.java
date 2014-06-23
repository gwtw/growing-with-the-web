package dataStructures.binarySearchTree;

import dataStructures.BinarySearchTree;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {
	private static final Logger log = Logger.getLogger(Program.class.getName());
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

		for( int i = 1; i <= 5; ++i ) {
			bst.insert(i);
		}
		log.log(Level.INFO, "degenerative binary tree as a list is {0}", bst );

		bst = new BinarySearchTree<Integer>();
		bst.insert(3);
		bst.insert(2);
		bst.insert(5);
		bst.insert(1);
		bst.insert(4);
		
		log.log(Level.INFO, "random binary tree is {0}", bst );	}
}
