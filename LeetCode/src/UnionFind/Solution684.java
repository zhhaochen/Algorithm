package UnionFind;

public class Solution684 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = 1;
        for (int[] edge : edges){
            n = Math.max(n, edge[0]);
            n = Math.max(n, edge[1]);
        }
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int[] res = new int[2];
        for (int[] edge : edges){
            int rootX = find(edge[0] - 1, parent);
            int rootY = find(edge[1] - 1, parent);
            // 已经联合在一起
            if (rootX == rootY){
                res[0] = edge[0];
                res[1] = edge[1];
            }else{
                // 进行联合
                parent[rootX] = parent[rootY];
            }
        }
        return res;
    }

    public int find(int x, int[] parent){
        if (x != parent[x]){
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
}
