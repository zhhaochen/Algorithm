package Amazon;

public class Solution7 {

    public int reverse2(int x){
        int res = 0;
        while (x != 0){
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) return 0;
            // 因为 x 合法，所以可以直接简单些
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    public int reverse(int x) {
        // 这里是为了避免取绝对值出现错误
        if (x == Integer.MIN_VALUE) return 0;
        int flag = x >= 0 ? 1 : -1;
        x = Math.abs(x);
        int res= 0;
        while (x != 0){
            int cur = x % 10;
            // 当出现此情况必定越界，不管正负
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && cur > 8)) return 0;
            // 因为要求不出现64位数，所以必须限定边界
            else if (flag == -1 && res == Integer.MAX_VALUE / 10 && x == 8) return Integer.MIN_VALUE;
            res = res * 10 + cur;
            x /= 10;
        }
        return flag * res;
    }
    public static void main(String[] args) {
        System.out.println(-323 % 10);
    }
}
