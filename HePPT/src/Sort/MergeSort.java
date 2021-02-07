package Sort;

// 分治思想，从中间划分，先排序左边，再排序右边，然后两个有序数组合并
// 时间 O(nlogn) 空间 O(n)
public class MergeSort {
    public void sort(int[] nums){
        merge(nums, 0, nums.length - 1);
    }
    public void merge(int[] nums, int left, int right){
        if(left >= right) return;
        int mid = (left + right) / 2;
        // 分别排序
        merge(nums, left, mid);
        merge(nums, mid + 1, right);
        int[] tmp = new int[right - left + 1]; // 辅助数组
        // 两个有序数组的合并
        int i = left, j = mid+1;
        for(int k = 0; k < tmp.length; k++){
            if(i > mid) tmp[k] = nums[j++];
            else if(j > right) tmp[k] = nums[i++];
            else if(nums[i] <= nums[j]) tmp[k] = nums[i++];
            else tmp[k] = nums[j++];
        }
        // 修改原数组
        for(i = left; i <= right; i++){
            nums[i] = tmp[i - left];
        }
    }
}