import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class PalindromeLL {
    public boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }
        if (values.size() == 1)
            return true;
        int mid = (int) values.size() / 2;
        for (int i = 0; i <= mid; i++) {
            if (values.get(i) != values.get(values.size() - 1 - i))
                return false;
        }
        return true;
    }
}
