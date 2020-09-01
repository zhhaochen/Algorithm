package Top100;

/**
 * 2020.08.31
 * Given a linked list, determine if it has a cycle in it.
 * To represent a cycle in the given linked list,
 * we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
 * If pos is -1, then there is no cycle in the linked list.
 */
public class Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        // 快慢指针的典型问题
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
