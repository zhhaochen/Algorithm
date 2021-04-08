package Hot100;

public class Solution96 {
    public int numTrees(int n) {
        if (n == 0 || n == 1) return n;
        int res = 0;
        for (int i = 1; i <= n; i++){
            int left = numTrees(i - 1);
            int right = numTrees(n - i);
            left = left == 0 ? 1 : left;
            right = right == 0 ? 1 : right;
            res += left * right;
        }
        return res;
    }
}
