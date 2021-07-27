package JianZhiOffer;

import Base.ListNode;

public class Solution18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode cur = head, pre = root;
        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return root.next;
    }
}
