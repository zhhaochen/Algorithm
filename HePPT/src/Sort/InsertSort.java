package Sort;

// 插入排序
// 每次选定一个往前面排好序的里面插入 最好情况O(N) 最差O(N^2)
public class InsertSort {
    public void sort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            int tmp = nums[i];
            int j;
            for(j = i; j > 0 && nums[j - 1] > tmp; j--){
                nums[j] = nums[j-1]; // 往后移动一位空出 j - 1
            }
            nums[j] = tmp;
        }
    }
}
