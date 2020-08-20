package Challenge_30_Day.week8;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place.
 * The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 */
public class Odd_Even_Linked_List {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode last = null;
        ListNode head2 = head.next;
        while (p1 != null && p2 != null) {
            last = p1;
            p1.next = p2.next;
            p1 = p1.next;
            if (p1 != null) {
                p2.next = p1.next;
                p2 = p2.next;
            }
        }
        if (p1 != null){
            p1.next = head2;
        }else {
            last.next = head2;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
