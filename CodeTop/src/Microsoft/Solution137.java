package Microsoft;

public class Solution137 {
    public int singleNumber(int[] nums) {
        int[] tmp = new int[32];
        for (int num : nums){
            for (int i = 31; i >= 0; i--){
                tmp[i] += (num & 1);
                num = num >>> 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) res |= ((tmp[i] % 3) & 1) << (31 - i);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-2,1,1,4,1,4,4,-4,-2};
        new Solution137().singleNumber(nums);
    }
}
