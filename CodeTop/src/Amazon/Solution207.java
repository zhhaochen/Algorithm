package Amazon;

import java.util.*;

public class Solution207 {
    // 拓扑排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 记录入度
        int[] degree = new int[numCourses];
        // 构建图
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] node : prerequisites){
            degree[node[0]]++;
            List<Integer> list = map.get(node[1]);
            if (list == null) list = new ArrayList<>();
            list.add(node[0]);
            map.put(node[1], list);
        }
        Queue<Integer> queue = new LinkedList<>();
        // 入度为0的节点
        for (int i = 0; i < numCourses; i++) if (degree[i] == 0) queue.offer(i);
        while (!queue.isEmpty()){
            List<Integer> list = map.get(queue.poll());
            numCourses--;
            if (list != null){
                for (int next : list){
                    degree[next]--;
                    if (degree[next] == 0) queue.offer(next);
                }
            }
        }
        return numCourses == 0;
    }
}
