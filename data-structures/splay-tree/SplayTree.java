public class SplayTree {
	private TreeNode root;
	  
	public SplayTree() { }
	 
	private void splay(TreeNode node) {
		while (node.parentExists()) {
			TreeNode parent = node.getParent();
			if (!parent.parentExists()) {
				if (parent.getLeft() == node) {
					rotateRight(parent);
				} else {
					rotateLeft(parent);
				}
			} else {
				TreeNode gparent = parent.getParent();
				if (parent.getLeft() == node && gparent.getLeft() == parent) {
					rotateRight(gparent);
					rotateRight(node.getParent());
				} else if (parent.getRight() == node && 
						gparent.getRight() == parent) {
					rotateLeft(gparent);
					rotateLeft(node.getParent());
				} else if (parent.getLeft() == node && 
						gparent.getRight() == parent) {
					rotateRight(parent);
					rotateLeft(node.getParent());
				} else {
					rotateLeft(parent);
					rotateRight(node.getParent());
				}
			}
		}
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
	
	public void insert(int key) {
	    if (root == null) {
	    	root = new TreeNode(key, null);
	    	return;
	    }
	    
	    insert(key, root);
	    search(key);
	}
	  
	private void insert(int key, TreeNode node) {
	    if (key < node.getKey()) {
	    	if (node.leftExists())
	    		insert(key, node.getLeft());
	    	else
	    		node.setLeft(new TreeNode(key, node));
	    }
	    
	    if (key > node.getKey()) {
	    	if (node.rightExists())
	    		insert(key, node.getRight());
	    	else
	    		node.setRight(new TreeNode(key, node));
	    }
	}
	  
	public void delete(int key) {
	    if (root == null)
	    	return;
	    
	    search(key);
	    delete(key, root);
	}
	  
	private void delete(int key, TreeNode node) {
	    if (key < node.getKey()) {
	    	if (node.leftExists())
	    		delete(key, node.getLeft());
	    	if (node.getLeft().isDeleted())
	    		node.setLeft(null);
	    	return;
	    }

	    if (key > node.getKey()) {
	    	if (node.rightExists())
	    		delete(key, node.getRight());
	    	if (node.getRight().isDeleted())
	    		node.setRight(null);
	    	return;
	    }
	    
	    delete(node);
	}
	  
	private void delete(TreeNode node) {
	    if (!(node.leftExists() || node.rightExists())) {
	    	node.setDeleted(true);
	    	return;
	    }

	    if (node.leftExists() && !node.rightExists()) {
	    	node.setKey(node.getLeft().getKey());
	    	if (node.getLeft().rightExists())
	    		node.setRight(node.getLeft().getRight());
	    	if (node.getLeft().leftExists())
	    		node.setLeft(node.getLeft().getLeft());
	    	else
	    		node.setLeft(null);
	    	return;
	    }

	    if (node.rightExists() && !node.leftExists()) {
	    	node.setKey(node.getRight().getKey());
	    	if (node.getRight().leftExists())
	    		node.setLeft(node.getLeft().getLeft());
	    	if (node.getRight().rightExists())
	    		node.setRight(node.getLeft().getRight());
	    	else
	    		node.setRight(null);
	    	return;
	    }
	    
	    // both exist, replace with minimum from right sub-tree
	    int min = findMin(node.getRight());
	    node.setKey(min);
	}
	  
	private int findMin(TreeNode node) {
	    if (!node.leftExists()) {
	    	node.setDeleted(true);
	    	return node.getKey();
	    }
	    
	    int min = findMin(node.getLeft());
	    if (node.getLeft().isDeleted())
	    	node.setLeft(null);
	    return min;
	}
	  
	public boolean search(int key) {
	    if (root == null)
	    	return false;
	    
	    TreeNode node = search(key, root);
	    splay(node);
	    return node != null;
	}
	  
	private TreeNode search(int key, TreeNode node) {
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
	    return root.toString();
	}
}
