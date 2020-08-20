package Linked_List;

/**
 * 2019.9.26
 * Rotate List
 * <p>
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 */

public class Solution61 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode head = rotateRight(l1, 5);
        while (head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
    private static ListNode rotateRight(ListNode head, int k) {
        ListNode current = head;
        ListNode end = head;
        int len = 0;
        while (current != null) {
            len++;
            end = current;
            current = current.next;
        }
        current = head;
        int count = 0;
        if (len != 0){
            //在长度不为0时取余数，否则直接为0
            count = k % len;
        }
        if (count == 0 || len == 1) {
            return head;
        }else {
            for (int i = 0; i<len-count-1; i++){
                current = current.next;
            }
            ListNode tmp = head;
            head = current.next;
            current.next = null;
            end.next = tmp;
        }
        return head;
    }
}
