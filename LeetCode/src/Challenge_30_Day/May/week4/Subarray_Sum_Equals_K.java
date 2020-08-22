package Challenge_30_Day.May.week4;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k,
 * you need to find the total number of continuous subarrays whose sum equals to k.
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 */
public class Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //如果出现sum=k时可用
        for (int i=0; i<nums.length; i++){
            sum += nums[i]; //遍历，看到目前的累计和是多少
            if (map.get(sum-k) != null){
                count += map.get(sum-k); //看看和为sum-k个数
            }
            if (map.get(sum) != null){
                int obj = map.get(sum);
                map.put(sum, obj+1); //放入子列的的统计个数
            }else {
                map.put(sum, 1);
            }
        }
        return count;
    }
}
