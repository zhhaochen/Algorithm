package JianZhi_Offer;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Solution56 {
    public ListNode deleteDuplication(ListNode pHead){
        if (pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            //此时这一块都是重复的
            while (next != null && pHead.val == next.val){
                next = next.next;
            }
            //递归查看，以next为头
            return deleteDuplication(next);
        } else {
            //如果传入这一段的开头不是重复的
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
