/**
 * 青蛙跳台阶
 * 总体是一个根据第一次跳递归剩下的问题
 */
public class Solution10_2 {
    //1、青蛙一次可以跳上1或2，求跳上一个n级台阶有多少种
    public int JumpFloor(int n){
        //1阶台阶，1种跳法
        //2阶台阶 1+1 或2 共两种
        //3阶台阶 先跳2阶+1 或跳1阶最后一下2
        //对n 跳n-1 + 1 或 n-2 + 2
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return JumpFloor(n-1) + JumpFloor(n-2);
    }

    //2、青蛙一次可以跳上1-n阶台阶，则总共有多少种跳法
    public int BTJumpFloor(int n){
        //1 1
        //2 1+1 2
        //3 1+() 2+() 3
        //f(n) = f(n-1) + f(n-2) + ... + f(1) => f(n) - f(n-1) = f(n-1) => f(n) = 2f(n-1)
        return (int)(Math.pow(2, n-1));
    }
}
