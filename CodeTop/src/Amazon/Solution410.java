package Amazon;

public class Solution410 {
    public int splitArray(int[] nums, int m) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        for (int num : nums){
            left = Math.max(left, num);
            right += num;
        }
        while (left <= right){
            int mid = left + (right - left) / 2;
            int cur = 0;
            int count = 1;
            for (int num : nums){
                if (cur + num > mid){
                    count++;
                    cur = 0;
                }
                cur += num;
            }
            if (count <= m) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}
