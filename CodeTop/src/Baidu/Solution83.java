package Baidu;

import Base.ListNode;

public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        // 找到头节点
        while (head.val == head.next.val){
            head = head.next;
            if (head.next == null) return head;
        }
        ListNode pre = head, cur = head.next;
        while (cur != null){
            if (cur.val != pre.val) pre = cur;
            else pre.next = cur.next;
            cur = cur.next;
        }
        return head;
    }
}
