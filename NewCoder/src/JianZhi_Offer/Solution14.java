package JianZhi_Offer;

/**
 * 2019.11.6
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution14 {
    /**
     * 双指针求法
     * 设置两指针p,q指向head
     * p先走k步，q再走
     * 当p走到(尾.next)时，q即走了len-k步，正好走到倒数第k个
     *  1 2 3 4 5
     */
    public ListNode FindKthToTail_(ListNode head, int k) {
        ListNode p = head, q = head;
        int a = k;
        int count = 0; //记录长度
        while (p != null) {
            p = p.next;
            count++;
            if (k < 1){
                q =q.next;
            }
            k--;
        }
        return a > count ? null : q;
    }

    // 暴力求解法
    public ListNode FindKthToTail(ListNode head, int k) {
        int count = 0;
        ListNode next = head;
        while (next != null) {
            count++;
            next = next.next;
        }
        k = count - k;
        if (k < 0) {
            return null;
        }
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        return head;
    }
}
