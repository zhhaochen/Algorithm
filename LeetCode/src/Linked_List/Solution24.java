package Linked_List;

/**
 * 2019.9.25
 * Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class Solution24 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode head = swapPairs(l1);
        while (head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
    private static ListNode swapPairs(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null){
            count++;
            current = current.next;
        }
        current = head;
        // 有可能传入为空
        if (count == 1 || count == 0){
            return head;
        }else {
            ListNode next = head.next;
            //先换第一次
            current.next = next.next;
            next.next = current;
            head = next;
            //换剩下的次数
            for (int i = 1; i<count/2; i++){
                next = current.next;
                current.next = next.next;
                next.next = current.next.next;
                current.next.next = next;
                current = next;
            }
        }
        return head;
    }
}
