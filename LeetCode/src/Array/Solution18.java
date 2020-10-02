package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2020.10.02
 * 4Sum
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * The solution set must not contain duplicate quadruplets.
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            int target_4 = target - nums[i];
            List<List<Integer>> tmp = threeSum(nums, i + 1, target_4);
            for (List<Integer> list : tmp){
                list.add(nums[i]);
                res.add(list);
            }
            while (i < nums.length - 1 && nums[i] == nums[i+1]) i++;
        }
        return res;
    }
    public List<List<Integer>> threeSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = start; i < nums.length; i++){
            int target_3 = target - nums[i];
            List<List<Integer>> tmp = twoSum(nums, i + 1, target_3);
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

    // nSum问题统一框架
    public List<List<Integer>> nSum(int[] nums, int n, int start, int target){
        List<List<Integer>> res = new ArrayList<>();
        int size = nums.length;
        if (n < 2 || size < n){
            return res;
        }
        if (n == 2){
            int l = start, h = nums.length - 1;
            while (l < h){
                int left = nums[l];
                int right = nums[h];
                if (left + right < target){
                    while (l < h && nums[l] == left) l++;
                }else if(left + right > target){
                    while (h > l && nums[h] == right) h--;
                }else if(left + right == target){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(left);
                    tmp.add(right);
                    res.add(tmp);
                    while (l < h && nums[l] == left) l++;
                    while (h > l && nums[h] == right) h--;
                }
            }
        }else {
            for (int i = start; i < size; i++){
                int subTarget = target - nums[i];
                List<List<Integer>> subSum = nSum(nums, n - 1, i + 1, subTarget);
                for (List<Integer> list : subSum){
                    list.add(nums[i]);
                    res.add(list);
                }
                while (i < size - 1 && nums[i] == nums[i+1]) i++;
            }
        }
        return res;
    }
}
