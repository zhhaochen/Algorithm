package JianZhi_Offer;

/**
 * 寻找有环的列表的入口节点
 *
 * 假设起点到入口的距离为a，入口到相遇点距离为b，相遇点到入口距离为c，假设相遇之前的慢指针已经在环里饶了n圈
 * 2 * (a + b + m * (b + c)) = a + b + (m + 1 + k) * (b + c)
 * m为慢走的圈数，k为快在慢进入时已走的圈数，k = a / (b + c) 向下取整
 * 而 a = k * (b + c) + a % (b + c)
 * 化简得a + b + m * (b + c) = (k + 1)(b + c)
 * 进一步得 a % (b + c) + m * (b + c) = c
 * 由此看出，要么 a %(b + c) = c, 要么 b = 0, m = 1, a %(b + c) = 0
 * 所以当fase放在头按1的速度开始时，走了a / (b + c)圈后
 * 第一种情况，慢此时也在距离c节点，然后同时走c步相遇
 * 第二种情况，两者已经相遇，即b = 0的时候
 */
public class Solution55 {
    public ListNode EntryNodeOfLoop(ListNode pHead){
        ListNode low = pHead;
        ListNode fast = pHead;
        while(low!=null && fast.next != null){
            low = low.next;
            fast = fast.next.next;
            // 如果有环
            if(low == fast){
                fast = pHead;
                //当两者相遇极为入口
                while(fast != low){
                    fast = fast.next;
                    low = low.next;
                }
                return fast;
            }
        }
        return null;
    }
}
