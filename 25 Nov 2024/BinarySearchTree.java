import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        this.data = val;
    }
}

public class BinarySearchTree {
    Node root;

    void insert(int val) {
        Node newNode = new Node(val);
        if (root == null) {
            root = newNode;
        } else {
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
    }

    void traversal(Node root) {
        if (root == null)
            return;
        traversal(root.left);
        System.out.print(root.data + " ");
        traversal(root.right);
    }

    void display() {
        Node curr = root;
        traversal(curr);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int[] values = new int[length];
        for (int i = 0; i < length; i++) {
            values[i] = scan.nextInt();
        }
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0; i < length; i++) {
            bst.insert(values[i]);
        }
        bst.display();
        scan.close();
    }
}
