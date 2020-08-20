package JianZhi_Offer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Solution48 {

    //递归解法
    public int Add(int num1,int num2) {
        //第二位作为进位计算
        return num2 == 0 ? num1 : Add(num1 ^ num2, (num1 & num2) << 1);
    }

    //循环解法
    public int Add2(int num1,int num2) {
        int sum = num1; //作为结果
        int c = num2; //作为进位
        while (c != 0){
            int tmp = sum;
            sum = sum ^ c;
            c = (tmp & c) << 1;
        }
        return sum;
    }
}
