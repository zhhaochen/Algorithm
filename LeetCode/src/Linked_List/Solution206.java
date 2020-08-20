package Linked_List;

/**
 * 2020.2.16
 * Reverse Linked List 反转单链表
 *
 * Reverse a singly linked list.
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */
public class Solution206 {
    //时间复杂度O(n)，空间复杂度O(1)
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur != null){
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next !=null){
                next = cur.next;
            }
        }
        return pre;
    }
    //更简单做法
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
