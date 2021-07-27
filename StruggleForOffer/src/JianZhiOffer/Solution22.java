package JianZhiOffer;

import Base.ListNode;

public class Solution22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode cur = root;
        for (int i = 0; i < k; i++){
            cur = cur.next;
        }
        ListNode pre = root;
        while (cur.next != null){
            pre = pre.next;
            cur = cur.next;
        }
        return pre.next;
    }
}
