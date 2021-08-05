package CodeTop.YuanFuDao;

import Base.ListNode;

public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        int index = 0;
        ListNode preTail = head, pre = head;
        ListNode cur = head.next;
        while (cur != null){
            // 奇数
            if (index % 2 == 1){
                // 断开
                pre.next = cur.next;
                cur.next = preTail.next;
                preTail.next = cur;
                preTail = cur;
                cur = pre.next;
            }else {
                pre = cur;
                cur = cur.next;
            }
            index++;
        }
        return head;
    }
}
