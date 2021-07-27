package DailyChallenge;

import java.util.Arrays;
import java.util.Map;

public class Solution1818 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = 1000000007;
        int sum = 0;
        int n = nums1.length;
        int max_index = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            int abs = Math.abs(nums1[i] - nums2[i]);
            sum += abs;
            max_index = abs > max ? i : max_index;
            sum %= mod;
        }
        int[] copy = Arrays.copyOfRange(nums1, 0, n);
        Arrays.sort(copy);
        int smaller = binary_search(nums1, nums2[max_index]);
        int larger = binary_search(nums1, nums2[max_index] + 1);
        if (smaller != -1 && larger != -1) sum -= Math.min(Math.abs(nums1[smaller] - nums2[max_index]),
                Math.abs(nums1[larger] - nums2[max_index]));
        else if (smaller == -1){

        }
        return sum;
    }

    private int binary_search(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }
}
