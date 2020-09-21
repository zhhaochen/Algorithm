package JianZhi_Offer;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Solution33 {
    public int GetUglyNumber_Solution(int index) {
        /**
         * 丑数 = 2^a * 3^b * 5^c
         * a = b = c = 0时，为 1
         * 牺牲空间，创建一个数组，除了1之外，每个丑数必定是前面某个数*2 *3 *5
         * 指定三个指针标记对应乘的地方
         */
        int[] res = new int[index];
        res[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < index; i++) {
            res[i] = Math.min(res[t2] * 2, Math.min(res[t3] * 3, res[t5] * 5));
            if (res[i] == res[t2] * 2) t2++;
            if (res[i] == res[t3] * 3) t3++;
            if (res[i] == res[t5] * 5) t5++;
        }
        return res[index-1];
    }
}
