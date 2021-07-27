package JianZhiOffer;

import Base.ListNode;

import java.util.Stack;

public class Solution6 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) res[i] = stack.pop();
        return res;
    }
}
