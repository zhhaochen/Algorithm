package Hot100;

import java.util.Arrays;

public class Solution338 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        int digit = 1;
        for (int i = 1; i <= num; i++){
            if (i == digit * 2){
                res[i] = 1;
                digit *= 2;
                continue;
            }
            res[i] = 1 + res[i - digit];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new Solution338().countBits(5);
        System.out.println(Arrays.toString(res));
    }
}
