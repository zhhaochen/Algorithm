package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2020.2.17
 * 3Sum
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * The solution set must not contain duplicate triplets.
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */

public class Solution15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums==null || nums.length<3)
            return result;
        Arrays.sort(nums); //[-4, -1, -1, 0, 1, 2]
        int index = 0;
        for (; index < nums.length; index++) {
            if (nums[index] >= 0) break;
        }
        
        return result;
    }
}
