package Challenge_30_Day.May.week6;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class Majority_Element {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        majorityElement(nums);
    }
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        if(n <= 2){
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(map.get(nums[i]) != null){
                int count = map.get(nums[i]);
                if (count+1 > n/2){
                    return nums[i];
                }else {
                    map.put(nums[i], count+1);
                }
            }else {
                map.put(nums[i], 1);
            }
        }
        return 0;
    }
}
