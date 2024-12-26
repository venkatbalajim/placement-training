class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class RemoveLLElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                if (prev != null) {
                    prev.next = curr.next;
                    if (prev.next != null) {
                        curr = prev.next;
                    } else {
                        curr = null;
                    }
                } else {
                    head = curr.next;
                    curr = head;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
