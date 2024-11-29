class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        this.data = val;
    }
}

public class HeightBinaryTree {
    int result = 0;

    void traversal(Node root, int level) {
        if (root == null) {
            result = Math.max(level - 1, result);
        } else {
            traversal(root.left, level + 1);
            traversal(root.right, level + 1);
        }
    }

    int height(Node node) {
        traversal(node, 0);
        return result;
    }
}
