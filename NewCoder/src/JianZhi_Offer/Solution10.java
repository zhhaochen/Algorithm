package JianZhi_Offer;

/**
 * 2019.11.9
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 当target = 1时，只有竖着一种排法
 * 当target = 2时，可以同时竖着或者同时横着，共两种
 * 则target = n时，相当于 f(n) = f(n-1) + f(n-2)，即最后一步排1个竖着或两个横着的情况
 */
public class Solution10 {
    public int RectCover(int target) {
        if (target == 0)
            return 0;
        if(target == 1)
            return 1;
        if (target==2)
            return 2;
        int pre = 1;
        int result = 2;
        for (int i = 3; i<=target;i++){
            int tmp = result;
            result += pre;
            pre = tmp;
        }
        return result;
    }
}
