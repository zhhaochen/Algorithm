package JianZhi_Offer;

/**
 * 2019.11.6
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Solution16 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode index = head;
        while (list1!=null && list2!=null){
            if (list1.val<=list2.val){
                index.next = list1;
                list1 = list1.next;
            }else {
                index.next = list2;
                list2 = list2.next;
            }
            index = index.next;
        }
        if (list1 != null){
            index.next = list1;
        }
        if (list2 != null){
            index.next = list2;
        }
        return head.next;
    }
}
