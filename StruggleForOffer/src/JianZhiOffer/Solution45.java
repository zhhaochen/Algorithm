package JianZhiOffer;

public class Solution45 {
    public String minNumber(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++){
            for (int j = 0; j < nums.length - 1 - i; j++){
                compareAndSwap(nums, j, j + 1);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int num : nums) sb.append(num);
        return sb.toString();
    }

    public void compareAndSwap(int[] nums, int i, int j){
        if (("" + nums[i] + nums[j]).compareTo("" + nums[j] + nums[i]) > 0){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
