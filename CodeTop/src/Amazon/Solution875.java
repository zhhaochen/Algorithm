package Amazon;

public class Solution875 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // 最少每天吃 1
        int right = Integer.MIN_VALUE; // 最多每天吃 max
        for (int plie : piles){
            right = Math.max(right, plie);
        }
        while (left <= right){
            int mid = left + (right - left) / 2;
            int hour = 0;
            for (int plie : piles) hour += (plie - 1) / mid + 1;
            if (hour <= h) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}
