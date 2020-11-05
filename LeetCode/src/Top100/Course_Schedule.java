package Top100;

import java.util.*;

/**
 * 2020.11.5
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 */
public class Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] in = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++){
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            if (!graph.containsKey(from)){
                graph.put(from, new ArrayList<>());
            }
            List<Integer> edge = graph.get(from);
            edge.add(to);
            // 入度+1，记录以to为先决条件的课程数；
            in[to]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if (in[i] == 0){
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            count++;
            if (!graph.containsKey(cur)){
                continue;
            }
            List<Integer> edge = graph.get(cur);
            for (int e : edge){
                in[e]--;
                if (in[e] == 0){
                    queue.offer(e);
                }
            }
        }
        return count == numCourses;
    }
}
