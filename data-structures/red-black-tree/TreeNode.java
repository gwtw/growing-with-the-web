
public class TreeNode {
	private final String nullNodeString = "_B";
	private TreeNode left;
	private TreeNode right;
	private TreeNode parent;
  
	private int key;
	private boolean isNilNode;
	private Color color;

	public TreeNode(int key, TreeNode parent) {
		this.key = key;
		this.parent = parent;
		this.color = Color.RED;
		this.setNilNode(false);
	}

	// Constructor for nil leaf node
	private TreeNode(TreeNode parent) {
		this.parent = parent;
		this.color = Color.BLACK;
		this.setNilNode(true);
	}
  
	public String toString() {
		if (isNilNode)
			return nullNodeString;
		return key + getColorCode() + " : { " + 
				(leftExists() ? left.toString() : nullNodeString) + " , " +
				(rightExists() ? right.toString() : nullNodeString) + " }";
	}
	
	private String getColorCode() {
		if (color == Color.BLACK)
			return "B";
		return "R";
	}
  
	public boolean leftExists() {
		return left != null;
	}
  
	public boolean rightExists() {
		return right != null;
	}
  
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public TreeNode getLeft() {
		// Create nil leaf nodes lazily
		if (left == null)
			left = new TreeNode(this);
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		// Create nil leaf nodes lazily
		if (right == null)
			right = new TreeNode(this);
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public TreeNode getParent() {
		return parent;
	}
	
	public TreeNode getGrandparent() {
		if (parent != null && parent.getParent() != null)
			return parent.getParent();
		return null;
	}
	
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isNilNode() {
		return isNilNode;
	}

	public void setNilNode(boolean isNilNode) {
		this.isNilNode = isNilNode;
	}

	public enum Color {
		BLACK,
		RED
	}
}