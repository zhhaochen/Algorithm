package Tencent;

import Base.ListNode;

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        int c = 0;
        ListNode p = root;
        while (l1 != null && l2 != null){
            p.next = new ListNode((l1.val + l2.val + c) % 10);
            c = (l1.val + l2.val + c) / 10;
            l1 = l1.next;
            l2 = l2.next;
            p = p.next;
        }
        ListNode cur = l1 != null ? l1 : l2;
        while (cur != null){
            p.next = new ListNode((cur.val + c) % 10);
            c = (cur.val + c) / 10;
            cur = cur.next;
            p = p.next;
        }
        if (c != 0) p.next = new ListNode(c);
        return root.next;
    }
}
