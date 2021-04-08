package Tencent;

import Base.ListNode;

public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode pre = root, nextHead = head, nextEnd = head, tail = null;
        while (true){
            for (int i = 0; i < k - 1; i++){
                if (nextEnd != null) nextEnd = nextEnd.next;
            }
            // 到头了
            if (nextEnd == null) break;
            tail = nextEnd.next;
            // 断开
            pre.next = null;
            nextEnd.next = null;
            // 翻转
            reverse(nextHead);
            // 拼接
            pre.next = nextEnd;
            nextHead.next = tail;
            // 下一段
            pre = nextHead;
            nextHead = tail;
            nextEnd = tail;
        }
        return root.next;
    }

    public void reverse(ListNode root){
        ListNode pre = null, next;
        while (root != null){
            next = root.next;
            root.next = pre;
            pre = root;
            root = next;
        }
    }
}
