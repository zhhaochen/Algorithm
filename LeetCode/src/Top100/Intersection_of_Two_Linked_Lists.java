package Top100;

/**
 * 2020.09.01
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 找两个链表的交点，要求On时间，O1空间
 */
public class Intersection_of_Two_Linked_Lists {
    // 解法1，算两链表长度差，从相同长度开始比较
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int cnt1 = 0;
        int cnt2 = 0;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null) {
            cnt1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            cnt2++;
            p2 = p2.next;
        }
        int d = cnt1 - cnt2;
        p1 = headA;
        p2 = headB;
        if (d >= 0) {
            while (d > 0) {
                p1 = p1.next;
                d--;
            }
        } else {
            while (d < 0) {
                p2 = p2.next;
                d++;
            }
        }
        while (p1 != null && p2 != null) {
            if (p1 == p2){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
    //解法2，环的思想，分别指向两个头，遍历到末尾时跳转到另一链表，则必在交点或各自结尾的null相遇，因为两者走过了同样的距离
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA, b = headB;
        while (a != b) {
            a = (a != null) ? a.next : headB;
            b = (b != null) ? b.next : headA;
        }
        return a;
    }
}
