package Linked_List;

/**
 * 2019.9.16
 * Remove Nth Node From End of List
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 1;
        ListNode current = head;
        while(current.next != null){
            len++;
            current = current.next;
        }
        current = head;
        n = len - n + 1;
        if(n == 1){
            current = head.next;
            return current;
        }else{
            for(int i = 0; i< n-2; i++){
                current = current.next;
            }
            current.next = current.next.next;
            return head;
        }
    }

}
