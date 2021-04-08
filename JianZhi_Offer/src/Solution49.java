public class Solution49 {
    public int nthUglyNumber(int n) {
        if (n < 7) return n;
        int[] res = new int[n];
        int index_2 = 0;
        int index_3 = 0;
        int index_5 = 0;
        res[0] = 1;
        for (int i = 1; i < n; i++){
            res[i] = Math.min(res[index_2] * 2, Math.min(res[index_3] * 3, res[index_5] * 5));
            index_2 = res[i] == res[index_2] * 2 ? index_2 + 1 : index_2;
            index_3 = res[i] == res[index_3] * 3 ? index_3 + 1 : index_3;
            index_5 = res[i] == res[index_5] * 5 ? index_5 + 1 : index_5;
        }
        return res[n-1];
    }
}
