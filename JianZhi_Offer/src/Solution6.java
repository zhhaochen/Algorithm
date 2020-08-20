import node.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，从尾到头打印
 */
public class Solution6 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode next = head;
        for (int i=1; i<10; i++){
            next.next = new ListNode(i);
            next = next.next;
        }
        showLinkList(head);
        ArrayList<Integer> list = new ArrayList<>();

    }

    /**
     * 1、问清是否可以改变链表的结构
     * 2、从尾部向头打印，即先进后出，栈结构
     */
    private static void showLinkList(ListNode head){
        ListNode p = head;
        Stack<Integer> stack = new Stack<>();
        while (p != null){
            stack.push(p.val);
            p = p.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
