package JianZhi_Offer;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */

public class Solution40 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 3, 4, 4, 5, 5};
        FindNumsAppearOnce(array, new int[1], new int[1]);
    }

    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int diff = 0;
        //最后得到的diff是两个不同的值得异或
        for (int num : array){
            diff ^= num;
        }
        System.out.println(diff);
        //注意补码表示，此处为了找到异或后的结果中从右往左第一个为1的位置
        diff &= -diff;
        System.out.println(diff);
        for (int num: array){
            //分开两组
            if ((num & diff) == 0){
                num1[0] ^= num;
            }else {
                num2[0] ^= num;
            }
        }
    }
}
