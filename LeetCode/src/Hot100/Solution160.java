package Hot100;

import Top100.ListNode;

public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode head1 = headA, head2 = headB;
        while(head1 != head2){
            head1 = head1 != null ? head1.next : headB;
            head2 = head2 != null ? head2.next : headA;
        }
        return head1;
    }
}
