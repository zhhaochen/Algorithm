package JianZhiOffer;

public class Solution64 {
    public int sumNums(int n) {
        int next = 0;
        boolean flag = n > 0 && (next = sumNums(n - 1)) > 0;
        return n + next;
    }
}
