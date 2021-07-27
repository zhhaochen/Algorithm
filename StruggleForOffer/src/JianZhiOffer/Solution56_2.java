package JianZhiOffer;

public class Solution56_2 {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int num : nums){
            for (int i = 31; i >= 0; i--){
                if ((num & 1) == 1) count[i]++;
                num = num >>> 1;
            }
        }
        int res = 0;
        for (int c : count){
            res = res << 1;
            res += c % 3;
        }
        return res;
    }
}
