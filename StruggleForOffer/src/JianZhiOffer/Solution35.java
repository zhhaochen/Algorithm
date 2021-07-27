package JianZhiOffer;

import Base.Node;

public class Solution35 {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node cur = head, next;
        // 插入 next
        while (cur != null){
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        // 插入 random
        cur = head;
        next = cur.next;
        while (cur != null){
            if (cur.random != null) next.random = cur.random.next;
            cur = next.next;
            if (cur != null) next = cur.next;
        }
        // 拆开
        cur = head;
        next = cur.next;
        Node root = next;
        while (cur != null){
            cur.next = next.next;
            next.next = null;
            cur = cur.next;
            if (cur != null){
                next.next = cur.next;
                next = cur.next;
            }
        }
        return root;
    }
}
