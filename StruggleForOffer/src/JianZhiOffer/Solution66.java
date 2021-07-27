package JianZhiOffer;

public class Solution66 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0 || len == 1) return new int[0];
        int[] res = new int[len];
        int pre = a[0];
        for (int i = 1; i < len; i++){
            res[i] = pre;
            pre *= a[i];
        }
        pre = 1;
        for (int i = len - 1; i > 0; i--){
            res[i] *= pre;
            pre *= a[i];
        }
        res[0] = pre;
        return res;
    }
}
