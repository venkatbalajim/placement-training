import java.util.ArrayList;

// Node class
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        this.data = val;
    }
}

// Pre-order traversal [root, left, right]
class PreOrder {
    ArrayList<Integer> list = new ArrayList<>();

    void traversal(Node root) {
        if (root == null)
            return;
        list.add(root.data);
        traversal(root.left);
        traversal(root.right);
    }

    ArrayList<Integer> preorder(Node root) {
        traversal(root);
        return list;
    }
}

// In-order traversal [left, root, right]
class InOrder {
    ArrayList<Integer> list = new ArrayList<>();

    void traversal(Node root) {
        if (root == null)
            return;
        traversal(root.left);
        list.add(root.data);
        traversal(root.right);
    }

    ArrayList<Integer> inorder(Node root) {
        traversal(root);
        return list;
    }
}

// Post-order traversal [left, right, root]
class PostOrder {
    ArrayList<Integer> list = new ArrayList<>();

    void traversal(Node root) {
        if (root == null)
            return;
        traversal(root.left);
        traversal(root.right);
        list.add(root.data);
    }

    ArrayList<Integer> postOrder(Node root) {
        traversal(root);
        return list;
    }
}

public class TreeTraversals {

}
