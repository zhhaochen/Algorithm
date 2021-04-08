package Hot100;

import Top100.ListNode;

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p = pre, fast = head, slow = head;
        for (int i = 0; i < n; i++) fast = fast.next;
        while (fast != null){
            slow = slow.next;
            p = p.next;
        }
        p.next = slow.next;
        return pre.next;
    }
}
