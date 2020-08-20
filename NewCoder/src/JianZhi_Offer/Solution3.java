package JianZhi_Offer;

import java.util.ArrayList;

/**
 * 2019.9.16
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */

public class Solution3 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(67);
        ListNode listNode2 = new ListNode(0);
        ListNode listNode3 = new ListNode(24);
        ListNode listNode4 = new ListNode(58);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ArrayList<Integer> list = printListFromTailToHead(listNode);
        System.out.println(list);
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null){
            return new ArrayList<Integer>();
        }else{
            ListNode current = listNode;
            int len = 1;
            while(current.next != null){
                len++;
                current = current.next;
            }
            current = listNode;
            int[] array = new int[len];
            for(int i = 0; i<len; i++){
                array[len-i-1] = current.val;
                current = current.next;
            }
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i<len; i++){
                list.add(new Integer(array[i]));
            }
            return list;
        }
    }
}
