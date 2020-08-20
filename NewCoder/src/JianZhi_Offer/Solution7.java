package JianZhi_Offer;

/**
 * 2019.9.18
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Solution7 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(Fibonacci(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(Fibonacci2(i) + " ");
        }
    }

    // 非递归做法 19ms 9308k
    public static int Fibonacci2(int n){
        int pre = 1;
        int result = 1;
        if (n > 0 && n<=39){
            if (n == 1 || n==2){
                return 1;
            }else {
                for (int i = 3; i<= n; i++){
                    int tmp = pre + result;
                    pre = result;
                    result = tmp;
                }
                return result;
            }
        }
        return 0;
    }

    // 递归 998ms 9552k
    public static int Fibonacci(int n) {
        if (n > 0 && n <= 39) {
            if (n == 1 || n == 2) {
                return 1;
            } else {
                return Fibonacci(n - 1) + Fibonacci(n - 2);
            }
        } else
            return 0;
    }
}
