package Amazon;

public class Solution1231 {
    public int maximizeSweetness(int[] sweetness, int K) {
        int left = Integer.MAX_VALUE;
        int right = 0;
        int ans = 0;
        for (int sweet : sweetness){
            left = Math.min(left, sweet); // 最起码能分到的最小的一块甜度
            right += sweet; // 如果 0 个人，自己吃一整块
        }
        right /= (K + 1);
        while (left <= right){
            int mid = left + (right - left) / 2;
            int people = 0;
            int cur = 0;
            for (int sweet : sweetness){
                // 先加上这一块
                cur += sweet;
                // 如果超过最小值，就可以分割出去
                if (cur >= mid){
                    people++;
                    cur = 0;
                    if (people == K + 1) break;
                }
            }
            // 一共要切割成 K + 1 块，如果按照当前能分给多于这么多人，说明最小的太小了
            if (people >= K + 1){
                ans = mid;
                left = mid + 1;
            }
            // 如果当前分给的小于要求人数，说明最小的太大
            else if (people < K + 1)right = mid - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int res = new Solution1231().maximizeSweetness(nums, 5);
    }
}
