package Hot100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution399_II {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size();
        UnionFind unionFind = new UnionFind(2 * size);
        // 1、预处理，将变量值与id进行映射，使并查集底层用数组实现
        Map<String, Integer> map = new HashMap<>(2 * size);
        int id = 0;
        for (int i = 0; i < size; i++){
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);
            if (!map.containsKey(var1)) map.put(var1, id++);
            if (!map.containsKey(var2)) map.put(var2, id++);
            unionFind.union(map.get(var1), map.get(var2), values[i]);
        }
        // 2、查询
        size = queries.size();
        double[] res = new double[size];
        for (int i = 0; i < size; i++){
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);
            Integer id1 = map.get(var1);
            Integer id2 = map.get(var2);
            if (id1 == null || id2 == null){
                res[i] = -1.0d;
            }else{
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }

    private class UnionFind{
        private int[] parent;
        // 指向父节点的权值
        private double[] weight;
        public UnionFind(int n){
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value){
            // 分别找x和y的父节点，此过程中也会进行压缩
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            parent[rootX] = rootY;
            //给定 x->y; 如果结果是 x->rootX; y->rootY; 将rootX -> rootY
            weight[rootX] = weight[y] * value / weight[x];
        }

        public int find(int x){
            // 如果当前节点还有父节点
            if (x != parent[x]){
                int origin = parent[x];
                // 接着向上找父节点
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX ==  rootY){
                return weight[x] / weight[y];
            }else {
                return -1.0d;
            }
        }
    }
}
