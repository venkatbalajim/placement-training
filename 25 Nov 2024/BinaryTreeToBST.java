import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeToBST {
    private List<Integer> list = new ArrayList<>();

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }

    private void constructBST(TreeNode root) {
        if (root == null) {
            return;
        } else {
            constructBST(root.left);
            root.val = list.remove(0);
            constructBST(root.right);
        }
    }

    @SuppressWarnings("unused")
    private void binaryTreeToBST(TreeNode root) {
        inorder(root);
        Collections.sort(list);
        constructBST(root);
    }
}
