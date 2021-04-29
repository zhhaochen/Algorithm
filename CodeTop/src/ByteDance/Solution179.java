package ByteDance;

public class Solution179 {
    // 基于冒泡排序
    public String largestNumber(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++){
            for (int j = 0; j < nums.length - i - 1; j++){
                cas(nums, j, j + 1);
            }
        }
        // 判断第一个是否为 0，避免出现[0, 0] -> 00
        if (nums[0] == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for (int num : nums) sb.append(num);
        return sb.toString();
    }

    private void cas(int[] nums, int i, int j){
        if ((nums[i] + "" + nums[j]).compareTo(nums[j] + "" + nums[i]) < 0){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
