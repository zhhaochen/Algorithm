package Hot100;

import java.util.Stack;

public class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int left = nums.length, right = 0;
        for (int i = 0; i < nums.length; i++){
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) left = Math.min(left, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) right = Math.max(right, stack.pop());
            stack.push(i);
        }
        return right > left ? right - left + 1: 0;
    }
}
