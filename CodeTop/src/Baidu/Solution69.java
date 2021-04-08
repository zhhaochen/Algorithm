package Baidu;

public class Solution69 {
    public int mySqrt(int x) {
        int left = 0, right = x, mid;
        while (left <= right){
            mid = left + (right - left) / 2;
            long multi = (long)mid * (long)mid;
            if (multi == x) return mid;
            else if(multi < x) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }
}
