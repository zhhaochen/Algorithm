package Hot100;

import java.util.*;

// 官方bfs解法
public class Solution399_III {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        // 节点与索引做一个映射
        for (List<String> equation : equations){
            if (!map.containsKey(equation.get(0))) map.put(equation.get(0), index++);
            if (!map.containsKey(equation.get(1))) map.put(equation.get(1), index++);
        }
        // 创建图
        List<Node>[] graph = new List[index];
        int size = equations.size();
        for (int i = 0; i < size; i++){
            int id1 = map.get(equations.get(i).get(0));
            int id2 = map.get(equations.get(i).get(1));
            if (graph[id1] == null) graph[id1] = new ArrayList<>();
            if (graph[id2] == null) graph[id2] = new ArrayList<>();
            graph[id1].add(new Node(id2, values[i]));
            graph[id2].add(new Node(id1, 1.0 / values[i]));
        }
        // 查找
        size = queries.size();
        double[] res = new double[size];
        for (int i = 0; i < size; i++){
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);
            double result = -1.0;
            if (map.containsKey(var1) && map.containsKey(var2)){
                int start = map.get(var1);
                int end = map.get(var2);
                if (start == end) result = 1.0;
                else{
                    // 缓存比值
                    double[] tmp = new double[index];
                    Arrays.fill(tmp, -1.0);
                    // 使用队列进行bfs
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(start);
                    tmp[start] = 1.0;
                    while (!queue.isEmpty() && tmp[end] < 0){
                        int cur = queue.poll();
                        // bfs 步骤
                        for (Node next : graph[cur]){
                            // 这个节点还没有访问过
                            if (tmp[next.index] < 0){
                                queue.offer(next.index);
                                tmp[next.index] = tmp[cur] * next.value;
                            }
                        }
                    }
                    result = tmp[end];
                }
            }
            res[i] = result;
        }
        return res;
    }
    private class Node{
        int index;
        double value;
        Node(int index, double value){
            this.index = index;
            this.value = value;
        }
    }
}
