package Top100;

public class Linked_List_Cycle_II {
    public ListNode detectCycle(ListNode head) {
        //快慢指针的扩展应用 https://www.cnblogs.com/hiddenfox/p/3408931.html
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                /**
                 * 当第一次相遇时，快比慢多走了一圈，且快的距离是慢的两倍，则慢走了一圈的距离
                 * 即 head_start + start_meet = 1_cycle
                 * 此时将fast放到head，slow继续，按照同样速度行进
                 * 再次相遇时，必定在圈的起始点相遇
                 * 因为slow距离起始点有 1_cycle - start_meet，fast有head_start
                 * 而 1_cycle - start_meet = head_start
                 */
                fast = head;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
