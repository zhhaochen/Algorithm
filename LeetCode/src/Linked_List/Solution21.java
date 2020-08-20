package Linked_List;

/**
 * 2019.9.17
 * Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode result = new ListNode(0);
        ListNode curr3 = result;
        while (curr1 != null && curr2 != null) {
            if (curr1.val <= curr2.val) {
                curr3.next = curr1;
                curr1 = curr1.next;
                curr3 = curr3.next;
            } else {
                curr3.next = curr2;
                curr2 = curr2.next;
                curr3 = curr3.next;
            }
        }
        if (curr1 != null) {
            curr3.next = curr1;
        }
        if (curr2 != null) {
            curr3.next = curr2;
        }
        return result.next;
    }

    //递归方法，值得借鉴
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else if (l1.val == l2.val) {
            ListNode tmp1 = l1.next;
            ListNode tmp2 = l2.next;
            l1.next = l2;
            l1.next.next = mergeTwoLists2(tmp1, tmp2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
