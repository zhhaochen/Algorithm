package Linked_List;

/**
 * 2020.2.16
 * Reverse Linked List II
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;
        //第二个新的头
        ListNode head2 = new ListNode(0);
        ListNode cur = head;
        ListNode cur2 = head2;
        for (int i = 1; i < m; i++) {
            cur2.next = cur;
            cur = cur.next;
            cur2 = cur2.next;
        }
        head = cur;
        ListNode pre = null;
        ListNode next = null;
        while (m <= n) {
            next =cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            m++;
        }
        head.next =  next;
        cur2.next = pre;
        return head2.next;
    }
    //简化版，实际上并没有简化
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (m == n || head == null)
            return head;
        //第二个新的头
        ListNode head2 = new ListNode(0);
        ListNode cur = head;
        ListNode cur2 = head2;
        int index = 1;
        ListNode pre = null;
        ListNode next = null;
        while (index <= n) {
            if (index < m){
                cur2.next = cur;
                cur = cur.next;
                cur2 = cur2.next;
            }else {
                if (index==m){
                    head = cur;
                }
                next =cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            index++;
        }
        head.next =  next;
        cur2.next = pre;
        return head2.next;
    }

    //官方版本
    public ListNode reverseBetween3(ListNode head, int m, int n) {

        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }
}
