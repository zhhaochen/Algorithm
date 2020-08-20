package JianZhi_Offer;

/**
 * 2019.11.6
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Solution15 {

    public ListNode ReverseList_(ListNode head){
        if (head == null){
            return null;
        }
        ListNode pre=null, next=null;
        while (head!=null){
            next=head.next;
            head.next=pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //解法1，过于繁琐，不需要列这么多种情况
    public ListNode ReverseList(ListNode head) {
        ListNode l1, l2;
        if (head == null) //没有节点
            return null;
        if (head.next == null){  //仅一节点
            return head;
        }
        if (head.next.next == null){ //仅两节点
            l1 = head.next;
            head.next = null;
            l1.next = head;
            return l1;
        }
        l1 = head.next;
        head.next = null;
        while (l1.next != null){
            l2 = l1.next;
            l1.next = head;
            head = l1;
            l1 = l2;
        }
        l1.next = head;
        return l1;
    }
}
