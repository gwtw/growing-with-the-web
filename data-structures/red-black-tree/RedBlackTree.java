
public class RedBlackTree {
	private TreeNode root;
	
	public RedBlackTree() { }
	
	public void insert(int key) {
		TreeNode parent = null;
		TreeNode node = root;
		while (node != null && !node.isNilNode()) {
			parent = node;
			if (key < parent.getKey())
				node = parent.getLeft();
			else 
				node = parent.getRight();
		}
		if (parent == null) {
			node = new TreeNode(key, null);
			root = node;
		} else {
			node.setParent(parent);
			node.setKey(key);
			node.setNilNode(false);
			node.setColor(TreeNode.Color.RED);
		}
		node.setColor(TreeNode.Color.RED);
		insertFixup(node);
	}
	
	private void insertFixup(TreeNode node) {
		while (node.getParent() != null && 
			   node.getGrandparent() != null && 
			   node.getParent().getColor() == TreeNode.Color.RED) {
			
			if (node.getParent() == node.getGrandparent().getLeft()) {
				TreeNode uncle = node.getGrandparent().getRight();
				if (uncle.getColor() == TreeNode.Color.RED) {
					node.getParent().setColor(TreeNode.Color.BLACK);
					uncle.setColor(TreeNode.Color.BLACK);
					node = node.getGrandparent();
					node.setColor(TreeNode.Color.RED);
				} else {
					if (node == node.getParent().getRight()) {
						node = node.getParent();
						rotateLeft(node);
					}
					node.getParent().setColor(TreeNode.Color.BLACK);
					node.getGrandparent().setColor(TreeNode.Color.RED);
					rotateRight(node.getGrandparent());
				}
			} else if (node.getParent() == node.getGrandparent().getRight()) {
				TreeNode uncle = node.getGrandparent().getLeft();
				if (uncle.getColor() == TreeNode.Color.RED) {
					node.getParent().setColor(TreeNode.Color.BLACK);
					uncle.setColor(TreeNode.Color.BLACK);
					node = node.getGrandparent();
					node.setColor(TreeNode.Color.RED);
				} else {
					if (node == node.getParent().getLeft()) {
						node = node.getParent();
						rotateRight(node);
					}
					node.getParent().setColor(TreeNode.Color.BLACK);
					node.getGrandparent().setColor(TreeNode.Color.RED);
					rotateLeft(node.getGrandparent());
				}
			}
		}
		root.setColor(TreeNode.Color.BLACK);
	}
	
	private void rotateLeft(TreeNode x) {
		TreeNode y = x.getRight();
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
	
	private void rotateRight(TreeNode x) {
		TreeNode y = x.getLeft();
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
	
	public void delete(int key) {
		TreeNode node = search(key);
		TreeNode y, x;
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
		if (y.getColor() == TreeNode.Color.BLACK)
			deleteFixup(x);
	}
	
	private void deleteFixup(TreeNode node) {
		while (node != root && node.getColor() == TreeNode.Color.BLACK) {
			if (node == node.getParent().getLeft()) {
				TreeNode w = node.getParent().getRight();
				if (w.getColor() == TreeNode.Color.RED) {
					w.setColor(TreeNode.Color.BLACK);
					node.getParent().setColor(TreeNode.Color.RED);
					rotateLeft(node.getParent());
				}
				if (w.getLeft().getColor() == TreeNode.Color.BLACK && 
					w.getRight().getColor() == TreeNode.Color.BLACK) {
					
					w.setColor(TreeNode.Color.RED);
					node = node.getParent();
				} else  {
					if (w.getRight().getColor() == TreeNode.Color.BLACK) {
						w.getLeft().setColor(TreeNode.Color.BLACK);
						w.setColor(TreeNode.Color.RED);
						rotateRight(w);
						w = node.getParent().getRight();
					}
					w.setColor(node.getParent().getColor());
					node.getParent().setColor(TreeNode.Color.BLACK);
					w.getRight().setColor(TreeNode.Color.BLACK);
					rotateLeft(node.getParent());
					node = root;
				}
			} else {
				TreeNode w = node.getParent().getLeft();
				if (w.getColor() == TreeNode.Color.RED) {
					w.setColor(TreeNode.Color.BLACK);
					node.getParent().setColor(TreeNode.Color.RED);
					rotateRight(node.getParent());
				}
				if (w.getRight().getColor() == TreeNode.Color.BLACK && 
					w.getLeft().getColor() == TreeNode.Color.BLACK) {
					
					w.setColor(TreeNode.Color.RED);
					node = node.getParent();
				} else  {
					if (w.getLeft().getColor() == TreeNode.Color.BLACK) {
						w.getRight().setColor(TreeNode.Color.BLACK);
						w.setColor(TreeNode.Color.RED);
						rotateLeft(w);
						w = node.getParent().getLeft();
					}
					w.setColor(node.getParent().getColor());
					node.getParent().setColor(TreeNode.Color.BLACK);
					w.getLeft().setColor(TreeNode.Color.BLACK);
					rotateRight(node.getParent());
					node = root;
				}
			}
		}
		node.setColor(TreeNode.Color.BLACK);
	}
	
	private TreeNode treeSuccessor(TreeNode node) {
		if (node.getRight() != null && !node.isNilNode())
			return treeMinimum(node.getRight());
		TreeNode successor = node.getParent();
		while (successor != null && !successor.isNilNode() && node == successor) {
			node = successor;
			successor = node.getParent();
		}
		return successor;
	}
	
	private TreeNode treeMinimum(TreeNode node) {
		while (!node.getLeft().isNilNode() && !node.isNilNode())
			node = node.getLeft();
		return node;
	}
	
	public TreeNode search(int key) {
	    if (root == null)
	    	return null;
	    
	    return search(key, root);
  	}
	  
	public TreeNode search(int key, TreeNode node) {
	    if (key == node.getKey())
	    	return node;
	    
	    if (key < node.getKey()) {
	    	if (!node.leftExists())
	    		return null;
	    	return search(key, node.getLeft());
	    }
	    
	    if (key > node.getKey()) {
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
