package JianZhiOffer;

public class Solution51 {
    public int reversePairs(int[] nums) {
        return reversePairs(nums, 0, nums.length - 1);
    }

    private int reversePairs(int[] nums, int i, int j){
        if (i >= j) return 0;
        int mid = i + (j - i) / 2;
        int left = reversePairs(nums, i, mid);
        int right = reversePairs(nums, mid + 1, j);
        int count = 0;
        int[] tmp = new int[j - i + 1];
        int index_right = j, index_left = mid;
        int tmp_index = j - i;
        while(index_left >= i && index_right > mid){
            if (nums[index_left] > nums[index_right]){
                count += (index_right - mid);
                tmp[tmp_index--] = nums[index_left--];
            }else{
                tmp[tmp_index--] = nums[index_right--];
            }
        }
        if (index_left >= i || index_right > mid){
            for (; index_left >= i; index_left--){
                tmp[tmp_index--] = nums[index_left];
            }
            for (; index_right > mid; index_right--){
                tmp[tmp_index--] = nums[index_right];
            }
        }
        for (int start = i; start <= j; start++){
            nums[start] = tmp[start - i];
        }
        return left + right + count;
    }
}
