package JianZhiOffer;

public class Solution56_1 {
    public int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        int flag = 0;
        for (int num : nums) flag ^= num;
        int p = 0;
        for (int i = 0; i < 32; i++){
            p = flag & (1 << i);
            if (p != 0) break;
        }
        for (int num : nums){
            if ((num & p) == 0) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }
}
