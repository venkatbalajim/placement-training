import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

// Node class
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

// Right view of a binary tree
class RightView {
    ArrayList<Integer> list = new ArrayList<>();

    void traversal(Node root, int index) {
        if (root == null)
            return;
        if (index < list.size()) {
            list.set(index, root.data);
        } else {
            list.add(root.data);
        }
        traversal(root.left, index + 1);
        traversal(root.right, index + 1);
    }

    ArrayList<Integer> rightView(Node root) {
        traversal(root, 0);
        return list;
    }
}

// Left view of a binary tree
class LeftView {
    ArrayList<Integer> list = new ArrayList<>();

    void traversal(Node root, int index) {
        if (root == null)
            return;
        if (index < list.size()) {
            list.set(index, root.data);
        } else {
            list.add(root.data);
        }
        traversal(root.right, index + 1);
        traversal(root.left, index + 1);
    }

    ArrayList<Integer> leftView(Node root) {
        traversal(root, 0);
        return list;
    }
}

// Bottom view of a binary tree
class BottomView {
    class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    ArrayList<Integer> bottomView(Node root) {
        if (root == null)
            return new ArrayList<>();

        ArrayList<Integer> result = new ArrayList<>();
        TreeMap<Integer, Integer> hdMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Node curr = queue.peek().node;
            int hd = queue.peek().hd;

            hdMap.put(hd, curr.data);

            queue.poll();

            if (curr.left != null) {
                queue.add(new Pair(curr.left, hd - 1));
            }
            if (curr.right != null) {
                queue.add(new Pair(curr.right, hd + 1));
            }
        }

        for (int value : hdMap.values()) {
            result.add(value);
        }

        return result;
    }
}

// Top view of a binary tree
class TopView {
    class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    ArrayList<Integer> topView(Node root) {
        if (root == null)
            return new ArrayList<>();

        ArrayList<Integer> result = new ArrayList<>();
        TreeMap<Integer, Integer> hdMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Node curr = queue.peek().node;
            int hd = queue.peek().hd;

            if (!hdMap.containsKey(hd)) {
                hdMap.put(hd, curr.data);
            }

            queue.poll();

            if (curr.left != null) {
                queue.add(new Pair(curr.left, hd - 1));
            }
            if (curr.right != null) {
                queue.add(new Pair(curr.right, hd + 1));
            }
        }

        for (int values : hdMap.values()) {
            result.add(values);
        }

        return result;
    }
}

public class ViewsBinaryTree {

}
