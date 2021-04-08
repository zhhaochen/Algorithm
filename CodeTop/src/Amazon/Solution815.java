package Amazon;

import java.util.*;

public class Solution815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        List<List<Integer>> graph = new ArrayList<>();
        int n = routes.length;
        for (int[] route : routes){
            graph.add(new ArrayList<>());
            Arrays.sort(route);
        }
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (check(routes[i], routes[j])){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        boolean[] visit = new boolean[n];
        boolean[] targets = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++){
            for (int cur : routes[i]){
                if (cur == source){
                    visit[i] = true;
                    queue.offer(i);
                }
                if (cur == target){
                    targets[i] = true;
                }
            }
        }
        int steps = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int cur = queue.poll();
                if (targets[cur]) return steps + 1;
                for (int next : graph.get(cur)){
                    if (!visit[next]){
                        visit[next] = true;
                        queue.offer(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private boolean check(int[] route1, int[] route2){
        int i = 0, j = 0;
        while (i < route1.length && j < route2.length){
            if (route1[i] == route2[j]) return true;
            if (route1[i] < route2[j]) i++;
            else j++;
        }
        return false;
    }
}
