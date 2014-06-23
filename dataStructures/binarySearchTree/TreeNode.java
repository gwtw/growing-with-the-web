public class TreeNode {
    private final String nullNodeString = "_";
    private TreeNode left;
    private TreeNode right;

    private int key;
    private boolean isDeleted = false;

    public TreeNode(int key) {
        this.key = key;
    }

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

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}