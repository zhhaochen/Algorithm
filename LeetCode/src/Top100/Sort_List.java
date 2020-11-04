package Top100;

/**
 * 2020.11.3
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */
public class Sort_List {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = head, slow = head, fast = head;
        // 为了将链表从中间分开
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return merge(sortList(head), sortList(slow));
    }
    // 合并两个有序链表
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode cur = new ListNode(-1);
        ListNode p = cur;
        while (l1 != null && l2 !=null){
            if (l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return cur.next;
    }
}
