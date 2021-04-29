package ByteDance;

public class Solution633 {
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right){
            long tmp = (long) left * (long) left + (long)right * (long) right;
            if (tmp == c) return true;
            else if(tmp < c) left++;
            else right--;
        }
        return false;
    }
}
