package Amazon;

import java.util.*;

public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] node : prerequisites){
            degree[node[0]]++;
            List<Integer> list = map.get(node[1]);
            if (list == null) list = new ArrayList<>();
            list.add(node[0]);
            map.put(node[1], list);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) if (degree[i] == 0) queue.offer(i);
        int index = 0;
        int[] res = new int[numCourses];
        while (!queue.isEmpty()){
            res[index++] = queue.peek();
            List<Integer> list = map.get(queue.poll());
            if (list != null){
                for (int next : list){
                    degree[next]--;
                    if (degree[next] == 0) queue.offer(next);
                }
            }
        }
        return index == numCourses ? res : new int[0];
    }
}
