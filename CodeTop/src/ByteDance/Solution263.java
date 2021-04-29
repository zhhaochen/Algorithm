package ByteDance;

public class Solution263 {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        if (n <= 6) return true;
        int[] digits = {2, 3, 5};
        for (int digit : digits){
            while ((n % digit) == 0) n /= digit;
        }
        return n == 1;
    }
}
