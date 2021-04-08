package Hot100;

import Top100.ListNode;

public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // 如果链表长度为单数，slow顺移
        if (fast != null) slow = slow.next;
        // 反转链表
        slow = reverse(slow);
        while (slow != null){
            if (head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode root){
        if (root == null || root.next == null) return root;
        ListNode pre = null, next = null;
        while (root != null){
            next = root.next;
            root.next = pre;
            pre = root;
            root = next;
        }
        return pre;
    }
}
