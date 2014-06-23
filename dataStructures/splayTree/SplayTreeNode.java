package dataStructures.splayTree;

public class SplayTreeNode<T extends Comparable<T>> {
	private final String nullNodeString = "_";
	private SplayTreeNode<T> left;
	private SplayTreeNode<T> right;
	private SplayTreeNode<T> parent;
	  
	private T key;
	private boolean isDeleted = false;
	
	public SplayTreeNode(T key, SplayTreeNode<T> parent) {
	    this.key = key;
	    this.parent = parent;
	}
	  
	@Override
	public String toString() {
		return key + " : { " +
				(leftExists() ? left.toString() : nullNodeString) + " , " +
				(rightExists() ? right.toString() : nullNodeString) + " }";
	}
	  
	public boolean leftExists() {
		return left != null;
	}
	  
	public boolean rightExists() {
		return right != null;
	}
	  
	public boolean parentExists() {
		return parent != null;
	}
	  
	public T getKey() {
	    return key;
	}
	
	public void setKey(T key) {
	    this.key = key;
	}
	
	public SplayTreeNode<T> getLeft() {
	    return left;
	}
	
	public void setLeft(SplayTreeNode<T> left) {
	    this.left = left;
	}
	
	public SplayTreeNode<T> getRight() {
	    return right;
	}
	
	public void setRight(SplayTreeNode<T> right) {
	    this.right = right;
	}
	
	public boolean isDeleted() {
	    return isDeleted;
	}
	
	public void setDeleted(boolean isDeleted) {
	    this.isDeleted = isDeleted;
	}

	public SplayTreeNode<T> getParent() {
		return parent;
	}
	
	public void setParent(SplayTreeNode<T> parent) {
		this.parent = parent;
	}
}