package Top100;

/**
 * 2020.09.16
 * 输入一个非负整数num，输出0 ~ num之间所有数的二进制表示中1的个数
 */
public class Counting_Bits {
    public static void main(String[] args) {
        int[] res = countBits(5);
        System.out.println("lll");
    }
    public static int[] countBits(int num) {
        // 分段进行，每一段都是在前一段的基础上多加1个
        int start = 1;
        int[] res = new int[num + 1];
        for (int i = 1; i<=num; i++){
            if (i >= start && i < 2 *start){
                res[i] = 1 + res[i % start];
            }else {
                start *= 2;
                res[i] = 1;
            }
        }
        return res;
    }
}
