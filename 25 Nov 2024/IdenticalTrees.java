class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        this.data = val;
    }
}

public class IdenticalTrees {
    boolean traversal(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1.data != root2.data)
            return false;

        boolean leftSide = false;
        boolean rightSide = false;

        boolean leftCond1 = root1.left != null && root2.left != null;
        boolean leftCond2 = root1.left == null && root2.left == null;

        if (leftCond1 || leftCond2) {
            leftSide = traversal(root1.left, root2.left);
        } else {
            leftSide = false;
        }

        boolean rightCond1 = root1.right != null && root2.right != null;
        boolean rightCond2 = root1.right == null && root2.right == null;

        if (rightCond1 || rightCond2) {
            rightSide = traversal(root1.right, root2.right);
        } else {
            rightSide = false;
        }

        return (leftSide && rightSide);
    }

    boolean isIdentical(Node r1, Node r2) {
        return traversal(r1, r2);
    }
}
