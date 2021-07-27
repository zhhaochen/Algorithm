package JianZhiOffer;

public class Solution3 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            while (nums[nums[i]] != nums[i]){
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != i) return nums[i];
        }
        return -1;
    }
}
