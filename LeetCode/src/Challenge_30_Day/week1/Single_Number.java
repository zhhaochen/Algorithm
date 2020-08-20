package Challenge_30_Day.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Input: [2,2,1]
 * Output: 1
 */
public class Single_Number {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 4};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            if (map.get(nums[i])==null){
                map.put(nums[i], 1);
            }else {
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
        for (Integer key : map.keySet()) {
            if(map.get(key)==1){
                return key;
            }
        }
        return 0;
    }
}
