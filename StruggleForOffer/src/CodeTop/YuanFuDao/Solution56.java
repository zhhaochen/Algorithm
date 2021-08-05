package CodeTop.YuanFuDao;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            return o1[0] - o2[0];
        });
        for (int[] interval : intervals){
            queue.offer(interval);
        }
        int left = queue.peek()[0], right = queue.poll()[1];
        List<int[]> list = new ArrayList<>();
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            if (cur[0] <= right) right = Math.max(right, cur[1]);
            else {
                list.add(new int[]{left, right});
                left = cur[0];
                right = cur[1];
            }
        }
        list.add(new int[]{left, right});
        int[][] res = new int[list.size()][2];
        int index = 0;
        for (int[] l : list) res[index++] = l;
        return res;
    }
}
