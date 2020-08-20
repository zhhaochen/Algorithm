package JianZhi_Offer;

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class Solution67 {
    //贪心算法，target>=5时，尽可能多剪3，剩下绳子为4时，剪成2x2
    public int cutRope(int target) {
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }
        int timesOf3 = target/3;
        //如果可以凑出一个4
        if(target - 3 * timesOf3 == 1){
            timesOf3--;
        }
        //这里只可能是0或1或2
        int timesOf2 = (target - 3 * timesOf3)/2;
        return (int)(Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }
}
