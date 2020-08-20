package Linked_List;

import java.util.HashMap;
import java.util.Map;

/**
 * 2019.9.27
 * Remove Duplicates from Sorted List II
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class Solution82 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l1 = deleteDuplicates(l1);
        while (l1 != null){
            System.out.print(l1.val+" ");
            l1 = l1.next;
        }
    }

    private static ListNode deleteDuplicates(ListNode head) {
        Map<Integer,Integer> counts = new HashMap<>();
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head.next;
        //先确定head的位置
        int standard = head.val;
        int count = 1;
        while (current != null){
            if (current.val == standard){
                count++;
                standard = current.val;
                current = current.next;
                if (current == null){ //防止出现 1->1->1->2->2的情况下返回2->2而不是null
                    head = current;
                    break;
                }
            }else {
                if (count != 1){
                    head = current;
                    count = 1;
                    standard = head.val;
                    current = current.next;
                }else {
                    break;
                }
            }
        }
        //head位置确定后进行移除重复，双指针
        if (head != null && head.next != null){
            current = head.next;
            standard = current.val;
        }else {
            return head;
        }
        ListNode point = current.next;
        while (point != null){
            if (point.val == standard){
                point = point.next;
            }else {
                current = point;
            }
        }
        return head;
    }
}
