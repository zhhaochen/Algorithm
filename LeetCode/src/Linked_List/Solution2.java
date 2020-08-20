package Linked_List;

/**
 * 2019.9.16
 * Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode result;
        if(l1.val + l2.val >= 10){
            result = new ListNode(l1.val + l2.val - 10);
            l1 = l1.next;
            l2 = l2.next;
            c = 1;
        }else{
            result = new ListNode(l1.val + l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode current = result;
        while(l1!=null && l2!=null){
            if(l1.val + l2.val + c >= 10){
                current.next = new ListNode(l1.val + l2.val + c - 10);
                l1 = l1.next;
                l2 = l2.next;
                current = current.next;
                c = 1;
            }else{
                current.next = new ListNode(l1.val + l2.val + c);
                l1 = l1.next;
                l2 = l2.next;
                current = current.next;
                c = 0;
            }
        }
        while(l1!=null && l2==null){
            if(l1.val + c >= 10){
                current.next = new ListNode(l1.val + c -10);
                l1 = l1.next;
                current = current.next;
                c = 1;
            }else{
                current.next = new ListNode(l1.val + c);
                l1 = l1.next;
                current = current.next;
                c = 0;
            }
        }
        while(l1==null && l2!=null){
            if(l2.val + c >= 10){
                current.next = new ListNode(l2.val + c -10);
                l2 = l2.next;
                current = current.next;
                c = 1;
            }else{
                current.next = new ListNode(l2.val + c);
                l2 = l2.next;
                current = current.next;
                c = 0;
            }
        }
        if(c == 1){
            current.next = new ListNode(1);
        }
        return result;
    }

    //官方答案
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
