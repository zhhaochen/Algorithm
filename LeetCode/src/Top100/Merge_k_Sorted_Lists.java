package Top100;

/**
 * 2020.11.30
 * You are given an array of k linked-lists lists,
 * each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 */
public class Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0){
            return null;
        }
        while (len != 1){
            for (int i = 0; i < len / 2; i++){
                lists[i] = mergeTwoLists(lists[2 * i], lists[2 * i + 1]);
            }
            if (len % 2 != 0){
                lists[len / 2] = lists[len - 1];
                len = len / 2 + 1;
            }else {
                len /= 2;
            }
        }
        return lists[0];
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (l1 != null && l2 != null){
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
        return res.next;
    }
}
