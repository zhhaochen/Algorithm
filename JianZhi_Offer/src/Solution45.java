public class Solution45 {
    public String minNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length - 1 - i; j++){
                // 类似于冒泡
                swap(nums, j, j+1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums) sb.append(num);
        return sb.toString();
    }

    public void swap(int[] nums, int i, int j){
        if ((nums[i] + "" + nums[j]).compareTo(nums[j] + "" + nums[i]) > 0){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
