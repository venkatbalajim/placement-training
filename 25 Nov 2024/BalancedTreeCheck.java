class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        this.data = val;
    }
}

public class BalancedTreeCheck {
    boolean status = true;

    int traversal(Node root, int level) {
        if (root == null)
            return 0;
        int left = traversal(root.left, level + 1);
        int right = traversal(root.right, level + 1);
        int height = 1 + Math.max(left, right);
        if (Math.abs(left - right) > 1)
            status = false;
        return height;
    }

    public boolean isBalanced(Node root) {
        @SuppressWarnings("unused")
        int height = traversal(root, 0);
        return status;
    }
}
