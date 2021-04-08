package Tencent;

import Base.ListNode;

public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddTail = head;
        ListNode evenHead = head.next, evenTail = evenHead;
        ListNode p = evenTail.next;
        boolean isOdd = true;
        while (p != null){
            ListNode tmp = p.next;
            // 如果当前值为奇数链表
            if (isOdd){
                oddTail.next = p;
                p.next = evenHead;
                evenTail.next = tmp;
                oddTail = p;
            }
            else evenTail = p;
            p = tmp;
            isOdd = !isOdd;
        }
        return head;
    }
}
