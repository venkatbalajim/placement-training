import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class ValidateBSTTree {
    private void inorder(TreeNode root, List<Integer> array) {
        if (root.left != null) {
            inorder(root.left, array);
        }
        array.add(root.val);
        if (root.right != null) {
            inorder(root.right, array);
        }
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> array = new ArrayList<>();
        inorder(root, array);
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) <= array.get(i - 1))
                return false;
        }
        return true;
    }
}
