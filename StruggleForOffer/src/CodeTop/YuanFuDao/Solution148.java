package CodeTop.YuanFuDao;

import Base.ListNode;

public class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head, slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 断开
        if (pre != null) pre.next = null;
        // 分别排序
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        head = new ListNode(-1);
        pre = head;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if (l1 != null) pre.next = l1;
        if (l2 != null) pre.next = l2;
        return head.next;
    }
}
