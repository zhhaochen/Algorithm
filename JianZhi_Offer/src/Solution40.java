public class Solution40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        quickSort(arr, 0, arr.length - 1, k);
        for (int i = 0; i < k; i++) res[i] = arr[i];
        return res;
    }

    public void quickSort(int[] nums, int l, int r, int k){
        if (l < 0 || r >= nums.length || l >= r) return;
        int index = partition(nums, l, r);
        if (index == k) return;
        else if(index > k) quickSort(nums, l, index - 1, k);
        else quickSort(nums, index + 1, r, k);
    }

    public int partition(int[] nums, int start, int end){
        int index = start;
        int tmp = nums[start];
        for (int i = start + 1; i <= end; i++){
            if (nums[i] <= tmp){
                nums[index++] = nums[i];
                nums[i] = nums[index];
            }
        }
        nums[index] = tmp;
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,2,4,2,2,3,1,4};
        int[] res = new Solution40().getLeastNumbers(arr, 8);
    }
}
