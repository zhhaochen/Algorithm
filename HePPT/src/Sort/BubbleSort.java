package Sort;

// 冒泡排序 最好情况O(N) 最差O(N^2)
public class BubbleSort {
    public void sort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int flag = 0;
            // 一趟冒泡排序，一趟过后 nums[nums.length - 1 - i]是它之前最大的
            for(int j = 0; j < nums.length - 1 - i; j++){
                if(nums[j] > nums[j+1]){
                    swap(nums, j, j + 1);
                    flag = 1;
                }
            }
            if (flag == 0) break; // 全程无变化，表明排序结束
        }
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
