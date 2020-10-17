package Top100;

/**
 * 2020.10.17
 * 找出数组总第k大的数
 * 假设 1<= k <= nums.length
 */

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array {
    public int findKthLargest(int[] nums, int k) {
        // 维护一个小顶堆，存储k个大数
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++){
            if (i < k){
                queue.add(nums[i]);
            }else {
                if (nums[i] > queue.peek()){
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        return queue.peek();
    }
}
