package Hot100;

public class Solution461 {
    public int hammingDistance(int x, int y) {
        int tmp = x ^ y;
        int res = 0;
        while(tmp != 0){
            res += (tmp & 1);
            tmp = tmp >> 1;
        }
        return res;
    }
}
