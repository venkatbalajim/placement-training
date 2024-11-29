class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        this.data = val;
    }
}

public class BalancedBSTTree {
    Node root;

    void insert(int val) {
        Node newNode = new Node(val);
        if (root == null) {
            root = newNode;
            return;
        }
        Node curr = root;
        while (true) {
            if (newNode.data < curr.data) {
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr.left = newNode;
                    break;
                }
            } else {
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr.right = newNode;
                    break;
                }
            }
        }
    }

    void divideConquer(int[] arr, int low, int high) {
        if (low > high)
            return;
        int mid = (int) (low + high) / 2;
        int elt = arr[mid];
        insert(elt);
        divideConquer(arr, low, mid - 1);
        divideConquer(arr, mid + 1, high);
    }

    public Node sortedArrayToBST(int[] nums) {
        divideConquer(nums, 0, nums.length - 1);
        return root;
    }
}
