package Sort;

import java.util.Arrays;

/**
 * 2020.10.02
 * Remove Covered Intervals
 * Given a list of intervals, remove all intervals that are covered by another interval in the list.
 * Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
 * After doing so, return the number of remaining intervals.
 * Input: intervals = [[1,4],[3,6],[2,8]]
 * Output: 2
 * Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
 */
public class Solution1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            // 按照起点升序排序，如果起点相同则根据中点降序排序
            if (a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++){
            int[] interval = intervals[i];
            // 如果完全被覆盖
            if (left <= interval[0] && right >= interval[1]){
                res++;
            }else if(right >= interval[0] && right <= interval[1]){
                // 如果相交，合并区间
                right = interval[1];
            }else if (right < interval[0]){
                // 完全不相交，更新比较区间
                left = interval[0];
                right = interval[1];
            }
        }
        return intervals.length - res;
    }
}
