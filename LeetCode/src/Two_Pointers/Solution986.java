package Two_Pointers;

import java.util.ArrayList;
import java.util.List;

/**
 * 2020.10.03
 * Interval List Intersections
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 * Return the intersection of these two interval lists.
 * 求所有区间的交集
 */
public class Solution986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A == null || B == null){
            return new int[0][];
        }
        int m = A.length;
        int n = B.length;
        if (m == 0 || n == 0){
            return new int[0][];
        }
        int p1 = 0, p2 = 0;
        List<List<Integer>> res_list = new ArrayList<>();
        while (p1 < m && p2 < n){
            // 情况1，A = [1, 3] B = [2, 4] 或 A = [2, 3] B = [1, 4]
            if (A[p1][1] >= B[p2][0] && A[p1][1] <= B[p2][1]){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(Math.max(A[p1][0], B[p2][0]));
                tmp.add(A[p1][1]);
                res_list.add(tmp);
                p1++;
            }else if (B[p2][1] >= A[p1][0] && B[p2][1] <= A[p1][1]){
                // 情况2 A = [2, 4] B = [1, 3] 或 A = [1, 4] B = [2, 3]
                List<Integer> tmp = new ArrayList<>();
                tmp.add(Math.max(A[p1][0], B[p2][0]));
                tmp.add(B[p2][1]);
                res_list.add(tmp);
                p2++;
            }else if (A[p1][1] < B[p2][0]){
                // 情况3 A = [1, 3] B = [4, 5]
                p1++;
            }else if (A[p1][0] > B[p2][1]){
                // 情况4 A = [4, 5] B = [1, 3]
                p2++;
            }
        }
        int[][] res = new int[res_list.size()][2];
        int index = 0;
        for(List<Integer> list : res_list){
            res[index][0] = list.get(0);
            res[index++][1] = list.get(1);
        }
        return res;
    }
}
