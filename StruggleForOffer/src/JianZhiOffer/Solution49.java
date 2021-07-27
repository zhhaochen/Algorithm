package JianZhiOffer;

public class Solution49 {
    public int nthUglyNumber(int n) {
        if (n < 7) return n;
        int[] tmp = new int[n];
        int index_2 = 0, index_3 = 0, index_5 = 0;
        tmp[0] = 1;
        for (int i = 1; i < n; i++){
            tmp[i] = Math.min(tmp[index_2] * 2, Math.min(tmp[index_3] * 3, tmp[index_5] * 5));
            if (tmp[i] == tmp[index_2] * 2) index_2++;
            if (tmp[i] == tmp[index_3] * 3) index_3++;
            if (tmp[i] == tmp[index_5] * 5) index_5++;
        }
        return tmp[n - 1];
    }
}
