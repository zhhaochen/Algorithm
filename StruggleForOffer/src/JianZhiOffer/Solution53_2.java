package JianZhiOffer;

public class Solution53_2 {
    public int missingNumber(int[] nums) {
        int pre = -1;
        for (int num : nums){
            if (num != pre + 1) return pre + 1;
            pre = num;
        }
        return nums.length;
    }
}
