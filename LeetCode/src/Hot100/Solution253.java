package Hot100;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] interval : intervals){
            // 如果某个会议室正好在之前用完了
            if (!queue.isEmpty() && interval[0] >= queue.peek()) queue.poll();
            queue.offer(interval[1]);
        }
        return queue.size();
    }
}
