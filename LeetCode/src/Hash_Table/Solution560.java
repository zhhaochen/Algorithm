package Hash_Table;

import java.util.HashMap;
import java.util.Map;

/**
 * 2020.4.22
 * Subarray Sum Equals K
 * Given an array of integers and an integer k,
 * you need to find the total number of continuous subarrays whose sum equals to k
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 * Hint:
 * Will Brute force work here? Try to optimize it.
 * Can we optimize it by using some extra space?
 * What about storing sum frequencies in a hash table? Will it be useful?
 * sum(i,j)=sum(0,j)-sum(0,i), where sum(i,j) represents the sum of all the elements from index i to j-1. Can we use this property to optimize it.
 */
public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //如果出现sum=k时可用
        for (int i=0; i<nums.length; i++){
            sum += nums[i]; //遍历，看到目前的累计和是多少
            if (map.get(sum-k) != null){
                /**
                 * 看看之前的和为sum-k的个数，因为如果有和为sum-k的的累计和，
                 * 比如sum(0,i)=sum-k, sum(0, j)=sum
                 * 则必有sum(i, j) = k
                 */
                count += map.get(sum-k);
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
