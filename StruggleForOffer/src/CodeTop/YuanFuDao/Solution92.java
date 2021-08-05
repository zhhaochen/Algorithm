package CodeTop.YuanFuDao;

import Base.ListNode;

public class Solution92 {

    public ListNode reverseBetween_best(ListNode head, int left, int right) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode pre = root;
        for(int i = 1; i < left; i++){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for(int i = left; i < right; i++){
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return root.next;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preHead = null, curHead = head;
        ListNode curTail = null, afterTail = head;
        for (int i = 1; i < left; i++){
            preHead = curHead;
            curHead = curHead.next;
        }
        for (int i = 0; i < right; i++){
            curTail = afterTail;
            afterTail = afterTail.next;
        }
        // 断尾
        curTail.next = null;
        // 反转
        reverseList(curHead);
        // 重连
        if (preHead != null){
            preHead.next = curTail;
            curHead.next = afterTail;
            return head;
        }else {
            curHead.next = afterTail;
            return curTail;
        }
    }

    private void reverseList(ListNode head){
        ListNode pre = null, cur = head, next;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
