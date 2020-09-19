package JianZhi_Offer;

/**
 * 两个链表的第一个公共节点
 */
public class Solution36 {
    public ListNode FindFirstCommonNode_simple(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        // 最后两者要么相交，要么同为null
        while(p1 != p2){
            p1 = (p1 != null) ? p1.next : pHead2;
            p2 = (p2 != null) ? p2.next : pHead1;
        }
        return p1;
    }
    // 复杂了
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int count = 2;
        while(p1 != null && p2 != null){
            if(p1 == p2){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
            if(p1 == null && count != 0){
                p1 = pHead2;
                count--;
            }
            if(p2 == null && count != 0){
                p2 = pHead1;
                count--;
            }
        }
        return null;
    }

}
