import java.util.ArrayList;

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() { }

    public void insert(int key) {
        if (root == null) {
            root = new TreeNode(key);
            return;
        }

        insert(key, root);
    }

    private void insert(int key, TreeNode node) {
        if (node == null) {
            node = new TreeNode(key);
            return;
        }

        if (key < node.getKey()) {
            if (node.leftExists())
                insert(key, node.getLeft());
            else
                node.setLeft(new TreeNode(key));
        }

        if (key > node.getKey()) {
            if (node.rightExists())
                insert(key, node.getRight());
            else
                node.setRight(new TreeNode(key));
        }
    }

    public void delete(int key) {
        if (root == null)
            return;

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
                node.setLeft(node.getRight().getLeft());
            if (node.getRight().rightExists())
                node.setRight(node.getRight().getRight());
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

        return search(key, root);
    }

    private boolean search(int key, TreeNode node) {
        if (key == node.getKey())
            return true;

        if (key < node.getKey()) {
            if (!node.leftExists())
                return false;
            return search(key, node.getLeft());
        }

        if (key > node.getKey()) {
            if (!node.rightExists())
                return false;
            return search(key, node.getRight());
        }

        return false;
    }

    public String toString() {
        return root.toString();
    }
}
