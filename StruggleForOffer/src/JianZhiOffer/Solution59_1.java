package JianZhiOffer;

import java.util.Deque;
import java.util.LinkedList;

public class Solution59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;
        while (index < k){
            while (!deque.isEmpty() && deque.peekLast() < nums[index]) deque.pollLast();
            deque.offer(nums[index++]);
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = deque.peekFirst();
        for (int i = 1; i < res.length; i++){
            if (deque.peekFirst() == nums[index - k]) deque.pollFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[index]) deque.pollLast();
            deque.offer(nums[index++]);
            res[i] = deque.peekFirst();
        }
        return res;
    }
}
