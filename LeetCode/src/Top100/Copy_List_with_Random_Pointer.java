package Top100;

/**
 * 2020.10.15
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 */
public class Copy_List_with_Random_Pointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        // 交织，A->B->C ====> A->A'->B->B'->C->C'
        while (p != null) {
            Node tmp = new Node(p.val);
            tmp.next = p.next;
            p.next = tmp;
            p = tmp.next;
        }
        p = head;
        Node next = p.next;
        // 指定copy的节点的random
        while (p != null) {
            if (p.random != null) {
                next.random = p.random.next;
            }
            p = next.next;
            if (p != null) {
                next = p.next;
            }
        }
        p = head;
        next = p.next;
        head = next;
        // 消除原来的节点，注意不能改变原来结构
        while (p != null) {
            // 这里修改回原来的结构
            p.next = next.next;
            p = next.next;
            if (p != null) {
                next.next = p.next;
                next = p.next;
            }
        }
        return head;
    }
}
