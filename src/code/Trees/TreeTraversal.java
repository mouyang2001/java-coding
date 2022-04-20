package code.Trees;

import java.util.LinkedList;
import java.util.List;

public class TreeTraversal {
    enum Traversal {
        preOrder,
        inOrder,
        postOrder
    }

    private final TreeNode root;
    private List<Integer> order;

    TreeTraversal(TreeNode root) {
        this.root = root;
    }

    public List<Integer> traverse(Traversal type) {
        order = new LinkedList<>();

        if (type == Traversal.preOrder) preOrder(root);
        else if (type == Traversal.inOrder) inOrder(root);
        else if (type == Traversal.postOrder) postOrder(root);

        return order;
    }

    // n, l, r
    public void preOrder(TreeNode root) {
        if (root == null) return;
        order.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    // l, n, r
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        order.add(root.val);
        inOrder(root.right);
    }

    // l, r, n
    public void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        order.add(root.val);
    }
}
