package JianZhi_Offer;

/**
 * 2019.11.5
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution11 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(0));
        System.out.println(NumberOf1_(0));
    }
    public static int NumberOf1(int n) {
        int count = 0;
        boolean flag = false;
        if (n<0){
            n = Integer.MAX_VALUE + n + 1;
            flag = true;
        }
        while (n != 0){
            if (n%2 == 1)
                count++;
            n /= 2;
        }
        if (flag)
            count++;
        return count;
    }

    public static int NumberOf1_(int n) {
        int count = 0;
        int flag = 1;
        // 数字在java中以补码形式存储，所以可以通过按位与操作进行计数
        for (int i =0; i<32; i++){
            if ((flag&n) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}
