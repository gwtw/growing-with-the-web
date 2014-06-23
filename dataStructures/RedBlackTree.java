package dataStructures;

import dataStructures.redBlackTree.*;

public class RedBlackTree<T extends Comparable<T>> {
	private RedBlackTreeNode root;
	
	public RedBlackTree() { }
	
	public void insert( T key) {
		RedBlackTreeNode<T> parent = null;
		RedBlackTreeNode<T> node = root;
		while (node != null && !node.isNilNode()) {
			parent = node;
			if (key.compareTo(parent.getKey()) < 0)
				node = parent.getLeft();
			else 
				node = parent.getRight();
		}
		if (parent == null) {
			node = new RedBlackTreeNode(key, null);
			root = node;
		} else {
			node.setParent(parent);
			node.setKey(key);
			node.setNilNode(false);
			node.setColor(RedBlackTreeNode.Color.RED);
		}
		node.setColor(RedBlackTreeNode.Color.RED);
		insertFixup(node);
	}
	
	private void insertFixup(RedBlackTreeNode<T> node) {
		while (node.getParent() != null && 
			   node.getGrandparent() != null && 
			   node.getParent().getColor() == RedBlackTreeNode.Color.RED) {
			
			if (node.getParent() == node.getGrandparent().getLeft()) {
				RedBlackTreeNode<T> uncle = node.getGrandparent().getRight();
				if (uncle.getColor() == RedBlackTreeNode.Color.RED) {
					node.getParent().setColor(RedBlackTreeNode.Color.BLACK);
					uncle.setColor(RedBlackTreeNode.Color.BLACK);
					node = node.getGrandparent();
					node.setColor(RedBlackTreeNode.Color.RED);
				} else {
					if (node == node.getParent().getRight()) {
						node = node.getParent();
						rotateLeft(node);
					}
					node.getParent().setColor(RedBlackTreeNode.Color.BLACK);
					node.getGrandparent().setColor(RedBlackTreeNode.Color.RED);
					rotateRight(node.getGrandparent());
				}
			} else if (node.getParent() == node.getGrandparent().getRight()) {
				RedBlackTreeNode<T> uncle = node.getGrandparent().getLeft();
				if (uncle.getColor() == RedBlackTreeNode.Color.RED) {
					node.getParent().setColor(RedBlackTreeNode.Color.BLACK);
					uncle.setColor(RedBlackTreeNode.Color.BLACK);
					node = node.getGrandparent();
					node.setColor(RedBlackTreeNode.Color.RED);
				} else {
					if (node == node.getParent().getLeft()) {
						node = node.getParent();
						rotateRight(node);
					}
					node.getParent().setColor(RedBlackTreeNode.Color.BLACK);
					node.getGrandparent().setColor(RedBlackTreeNode.Color.RED);
					rotateLeft(node.getGrandparent());
				}
			}
		}
		root.setColor(RedBlackTreeNode.Color.BLACK);
	}
	
	private void rotateLeft(RedBlackTreeNode<T> x) {
		RedBlackTreeNode<T> y = x.getRight();
		x.setRight(y.getLeft());
		if (y.getLeft() != null)
			y.getLeft().setParent(x);
		y.setParent(x.getParent());
		if (x.getParent() == null)
			root = y;
		else {
			if (x == x.getParent().getLeft())
				x.getParent().setLeft(y);
			else
				x.getParent().setRight(y);
		}
		y.setLeft(x);
		x.setParent(y);
	}
	
	private void rotateRight(RedBlackTreeNode<T> x) {
		RedBlackTreeNode<T> y = x.getLeft();
		x.setLeft(y.getRight());
		if (y.getRight() != null)
			y.getRight().setParent(x);
		y.setParent(x.getParent());
		if (x.getParent() == null)
			root = y;
		else {
			if (x == x.getParent().getLeft())
				x.getParent().setLeft(y);
			else
				x.getParent().setRight(y);
		}
		y.setRight(x);
		x.setParent(y);
	}
	
	public void delete(T key) {
		RedBlackTreeNode<T> node = search(key);
		RedBlackTreeNode<T> y, x;
		if (node.getLeft().isNilNode() || node.getRight().isNilNode()) 
			y = node;
		else
			y = treeSuccessor(node);
		if (y.getLeft() != null && !y.getLeft().isNilNode())
			x = y.getLeft();
		else
			x = y.getRight();
		x.setParent(y.getParent());
		if (y.getParent() == null)
			root = x;
		else {
			if (y == y.getParent().getLeft())
				y.getParent().setLeft(x);
			else
				y.getParent().setRight(x);
		}
		if (y != node)
			node.setKey(y.getKey());
		if (y.getColor() == RedBlackTreeNode.Color.BLACK)
			deleteFixup(x);
	}
	
	private void deleteFixup(RedBlackTreeNode<T> node) {
		while (node != root && node.getColor() == RedBlackTreeNode.Color.BLACK) {
			if (node == node.getParent().getLeft()) {
				RedBlackTreeNode w = node.getParent().getRight();
				if (w.getColor() == RedBlackTreeNode.Color.RED) {
					w.setColor(RedBlackTreeNode.Color.BLACK);
					node.getParent().setColor(RedBlackTreeNode.Color.RED);
					rotateLeft(node.getParent());
				}
				if (w.getLeft().getColor() == RedBlackTreeNode.Color.BLACK && 
					w.getRight().getColor() == RedBlackTreeNode.Color.BLACK) {
					
					w.setColor(RedBlackTreeNode.Color.RED);
					node = node.getParent();
				} else  {
					if (w.getRight().getColor() == RedBlackTreeNode.Color.BLACK) {
						w.getLeft().setColor(RedBlackTreeNode.Color.BLACK);
						w.setColor(RedBlackTreeNode.Color.RED);
						rotateRight(w);
						w = node.getParent().getRight();
					}
					w.setColor(node.getParent().getColor());
					node.getParent().setColor(RedBlackTreeNode.Color.BLACK);
					w.getRight().setColor(RedBlackTreeNode.Color.BLACK);
					rotateLeft(node.getParent());
					node = root;
				}
			} else {
				RedBlackTreeNode w = node.getParent().getLeft();
				if (w.getColor() == RedBlackTreeNode.Color.RED) {
					w.setColor(RedBlackTreeNode.Color.BLACK);
					node.getParent().setColor(RedBlackTreeNode.Color.RED);
					rotateRight(node.getParent());
				}
				if (w.getRight().getColor() == RedBlackTreeNode.Color.BLACK && 
					w.getLeft().getColor() == RedBlackTreeNode.Color.BLACK) {
					
					w.setColor(RedBlackTreeNode.Color.RED);
					node = node.getParent();
				} else  {
					if (w.getLeft().getColor() == RedBlackTreeNode.Color.BLACK) {
						w.getRight().setColor(RedBlackTreeNode.Color.BLACK);
						w.setColor(RedBlackTreeNode.Color.RED);
						rotateLeft(w);
						w = node.getParent().getLeft();
					}
					w.setColor(node.getParent().getColor());
					node.getParent().setColor(RedBlackTreeNode.Color.BLACK);
					w.getLeft().setColor(RedBlackTreeNode.Color.BLACK);
					rotateRight(node.getParent());
					node = root;
				}
			}
		}
		node.setColor(RedBlackTreeNode.Color.BLACK);
	}
	
	private RedBlackTreeNode<T> treeSuccessor(RedBlackTreeNode<T> node) {
		if (node.getRight() != null && !node.isNilNode())
			return treeMinimum(node.getRight());
		RedBlackTreeNode<T> successor = node.getParent();
		while (successor != null && !successor.isNilNode() && 
				node == successor) {
			node = successor;
			successor = node.getParent();
		}
		return successor;
	}
	
	private RedBlackTreeNode<T> treeMinimum(RedBlackTreeNode<T> node) {
		while (!node.getLeft().isNilNode() && !node.isNilNode())
			node = node.getLeft();
		return node;
	}
	
	public RedBlackTreeNode<T> search(T key) {
	    if (root == null)
	    	return null;
	    
	    return search(key, root);
  	}
	  
	public RedBlackTreeNode<T> search( T key, RedBlackTreeNode<T> node) {
	    if (key == node.getKey())
	    	return node;
	    
	    if (key.compareTo( node.getKey() ) < 0) {
	    	if (!node.leftExists())
	    		return null;
	    	return search(key, node.getLeft());
	    }
	    
	    if (key.compareTo( node.getKey() ) >= 0) {
	    	if (!node.rightExists())
	    		return null;
	    	return search(key, node.getRight());
	    }
	    
	    return null;
	}
	
	public String toString() {
		if (root == null)
			return "(empty)";
		return root.toString();
	}
}
