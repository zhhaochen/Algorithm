package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return new int[0][0];
        }
        Arrays.sort(intervals, (a, b) ->{
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        List<List<Integer>> res_list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(intervals[0][0]);
        tmp.add(intervals[0][1]);
        res_list.add(tmp);
        for(int i = 1; i<intervals.length; i++){
            int[] interval = intervals[i];
            tmp = res_list.get(res_list.size() - 1);
            // 如果与前一个合并区间相交，则合并新的区间
            if (interval[0] <= tmp.get(1)){
                tmp.set(1, Math.max(interval[1], tmp.get(1)));
            }else {
                tmp = new ArrayList<>();
                tmp.add(interval[0]);
                tmp.add(interval[1]);
                res_list.add(tmp);
            }
        }
        int[][] res = new int[res_list.size()][2];
        int index = 0;
        for (List<Integer> list : res_list){
            res[index][0] = list.get(0);
            res[index][1] = list.get(1);
            index++;
        }
        return res;
    }
}
