public class DiameterBinaryTree {
    int answer = 0;

    int traversal(Node root) {
        if (root == null)
            return 0;
        int left = traversal(root.left);
        int right = traversal(root.right);
        answer = Math.max(answer, left + right);
        return Math.max(left, right) + 1;
    }

    int diameter(Node root) {
        traversal(root);
        return answer;
    }
}
