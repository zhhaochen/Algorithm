package Hot100;

import java.util.*;

public class Solution399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];

        // 建图
        Set<String> set = new HashSet<>();
        Map<String, List<Pair>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++){
            String key = equations.get(i).get(0);
            String value = equations.get(i).get(1);
            if (graph.containsKey(key)){
                graph.get(key).add(new Pair(value, values[i]));
            }else {
                List<Pair> tmp = new ArrayList<>();
                tmp.add(new Pair(value, values[i]));
                graph.put(key, tmp);
            }
            if (graph.containsKey(value)){
                graph.get(value).add(new Pair(key, 1.0 / values[i]));
            }else {
                List<Pair> tmp = new ArrayList<>();
                tmp.add(new Pair(key, 1.0 / values[i]));
                graph.put(value, tmp);
            }
            set.add(key);
            set.add(value);
        }
        Map<String,Integer> map = new HashMap<>();
        // 查找
        int index = 0;
        for (List<String> query : queries){
            String key = query.get(0);
            String value = query.get(1);
            if (!set.contains(key) && !set.contains(value)) res[index++] = -1.0;
            else if (key.equals(value)) res[index++] = 1.0;
            else{
                res[index++] = bfs(key, value, map, 1.0, graph);
            }
        }
        return res;
    }

    private double bfs(String start, String end, Map<String, Integer> map, double pre, Map<String, List<Pair>> graph){
        // 往下再找不到了或者当前节点已经被访问过
        if (!graph.containsKey(start) || map.containsKey(start)) return -1.0;
        double res = -1.0;
        map.put(start, 0);
        List<Pair> cur = graph.get(start);
        // bfs先一遍遍历
        for (Pair node : cur){
            if (node.equation.equals(end)){
                map.remove(start);
                return pre * node.value;
            }
        }
        // 下一层查询
        for (Pair node : cur){
            double tmp = bfs(node.equation, end, map, pre * node.value, graph);
            if (tmp != -1.0){
                res = tmp;
                break;
            }
        }
        map.remove(start);
        return res;
    }

    static class Pair{
        String equation;
        double value;
        public Pair(String equation, double value){
            this.equation = equation;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("b", "a"));
        new Solution399().calcEquation(equations, values, queries);
    }
}
