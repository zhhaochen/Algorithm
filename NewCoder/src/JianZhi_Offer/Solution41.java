package JianZhi_Offer;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 */
public class Solution41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int low = 1;
        int high = 2;
        int curSum = low + high;
        while (high<sum && low<high){
            if (curSum < sum){
                high++;
                curSum+=high;
            }else if (curSum > sum){
                curSum -= low;
                low++;
            }else {
                ArrayList<Integer> sub_res = new ArrayList<>();
                for (int i=low; i<=high; i++){
                    sub_res.add(i);
                }
                result.add(sub_res);
                curSum -= low;
                low++;
                high++;
                curSum += high;
            }
        }
        return result;
    }
}
