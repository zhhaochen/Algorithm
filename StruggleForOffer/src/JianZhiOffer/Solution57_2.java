package JianZhiOffer;

import java.util.ArrayList;
import java.util.List;

public class Solution57_2 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int len = (target + 1) / 2;
        int left = 1, right = 1;
        while (left <= right && right <= len){
            int tmp = (right + left) * (right - left + 1) / 2;
            if (tmp < target) right++;
            else if (tmp > target) left++;
            else{
                if (left != right){
                    int[] save = new int[right - left + 1];
                    for (int i = left; i <= right; i++) save[i - left] = i;
                    list.add(save);
                    left++;
                }else right++;
            }
        }
        int[][] res = new int[list.size()][];
        return list.toArray(res);
    }
}
