package JianZhi_Offer;

/**
 * 寻找有环的列表的入口节点
 */
public class Solution55 {
    public ListNode EntryNodeOfLoop(ListNode pHead){
        ListNode low = pHead;
        ListNode fast = pHead;
        while(low!=null && fast.next != null){
            low = low.next;
            fast = fast.next.next;
            // 如果有环
            if(low == fast){
                fast = pHead;
                //当两者相遇极为入口
                while(fast != low){
                    fast = fast.next;
                    low = low.next;
                }
                return fast;
            }
        }
        return null;
    }
}
