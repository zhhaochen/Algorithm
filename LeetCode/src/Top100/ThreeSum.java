package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2020.10.02
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Notice that the solution set must not contain duplicate triplets.
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            int target = - nums[i];
            List<List<Integer>> tmp = twoSum(nums, i + 1, target);
            for (List<Integer> list : tmp){
                list.add(nums[i]);
                res.add(list);
            }
            while (i < nums.length - 1 && nums[i] == nums[i+1]) i++;
        }
        return res;
    }
    // 排序 + 双指针实现2sum
    public List<List<Integer>> twoSum(int[] nums, int start, int target){
        // 单独的需要先排序，排序这一步在调用前做了
        // Arrays.sort(nums);
        int l = start, h = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (l < h){
            int left = nums[l];
            int right = nums[h];
            if (left + right < target){
                while (l < h && nums[l] == left) l++;
            }else if (left + right > target){
                while (h > l && nums[h] == right) h--;
            }else if (left + right == target){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(left);
                tmp.add(right);
                res.add(tmp);
                while (l < h && nums[l] == left) l++;
                while (h > l && nums[h] == right) h--;
            }
        }
        return res;
    }
}
