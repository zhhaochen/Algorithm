package Top100;

/**
 * 2020.09.03
 * 回文链表
 * Given a singly linked list, determine if it is a palindrome.
 * Input: 1->2->2->1
 * Output: true
 */

public class Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode p = head;
        int cnt = 0;
        while(p != null){
            p = p.next;
            cnt++;
        }
        // 计数，将一半进行反转链表
        if(cnt % 2 == 0){
            cnt = cnt / 2 -1;
        }else{
            cnt /= 2;
        }
        p = head;
        while(cnt > 0){
            p = p.next;
            cnt--;
        }
        //反转链表
        p.next = invertList(p.next);
        while(p.next != null){
            if(head.val != p.next.val){
                return false;
            }
            head = head.next;
            p = p.next;
        }
        return true;
    }
    private ListNode invertList(ListNode head){
        if(head == null){
            return null;
        }
        ListNode pre = head;
        ListNode next = head.next;
        pre.next = null; // 这里一定要置为空，否则会成环进入死循环
        while(next != null){
            ListNode p = next.next;
            next.next = pre;
            pre = next;
            next = p;
        }
        return pre;
    }
}
