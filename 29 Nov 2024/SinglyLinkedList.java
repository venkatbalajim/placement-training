// Node class
class Node {
    int data;
    Node next;

    Node(int val) {
        this.data = val;
    }
}

// Singly linked list
public class SinglyLinkedList {
    Node head;

    // Insert new node at the beginning
    void insertBegin(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // Insert new node at the end
    void insertEnd(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    // Insert new node at specific index
    void insertIndex(int val, int index) {
        if (index == 0) {
            insertBegin(val);
        }
        Node newNode = new Node(val);
        Node prev = null;
        Node curr = head;
        int idx = 0;
        while (curr != null) {
            if (idx == index) {
                prev.next = newNode;
                newNode.next = curr;
                return;
            } else {
                idx++;
                prev = curr;
                curr = curr.next;
            }
        }
        if (idx < index) {
            throw new IndexOutOfBoundsException("Entered index is out of bound.");
        }
    }

    // Delete node at the beginning
    void deleteBegin() {
        if (head == null) {
            throw new IndexOutOfBoundsException("Linked list is empty.");
        } else if (head.next == null) {
            head = null;
        } else {
            head = head.next;
        }
    }

    // Delete node at the end
    void deleteEnd() {
        if (head == null) {
            throw new IndexOutOfBoundsException("Linked list is empty.");
        } else if (head.next == null) {
            head = null;
        } else {
            Node prev = null;
            Node curr = head;
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
        }
    }

    // Delete node at specific index
    void deleteIndex(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException("Linked list is empty.");
        } else {
            if (index == 0) {
                deleteBegin();
            } else {
                Node prev = null;
                Node curr = head;
                int idx = 0;
                while (curr != null) {
                    if (idx == index) {
                        prev.next = curr.next;
                        curr = prev.next;
                        return;
                    } else {
                        idx++;
                        prev = curr;
                        curr = curr.next;
                    }
                }
                if (idx < index) {
                    throw new IndexOutOfBoundsException("Entered index is out of bound.");
                }
            }
        }
    }

    // Print the linked list
    void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
        } else {
            Node curr = head;
            while (curr != null) {
                System.out.printf("%d ", curr.data);
                curr = curr.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertEnd(10); // 10
        sll.insertEnd(20); // 10 20
        sll.insertEnd(30); // 10 20 30
        sll.insertBegin(40); // 40 10 20 30
        sll.insertBegin(50); // 50 40 10 20 30
        sll.insertBegin(60); // 60 50 40 10 20 30
        sll.insertIndex(100, 3); // 60 50 40 100 10 20 30
        sll.deleteBegin(); // 50 40 100 10 20 30
        sll.deleteEnd(); // 50 40 100 10 20
        sll.deleteIndex(2); // 50 40 10 20
        sll.display();
    }
}
