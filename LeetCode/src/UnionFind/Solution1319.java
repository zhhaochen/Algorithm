package UnionFind;

public class Solution1319 {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        // 建立集合
        for (int[] conn : connections){
            union(conn[0], conn[1], parent);
        }
        int count = 0;
        for (int i = 0; i < n; i++){
            if (parent[i] == i) count++;
        }
        // 此时还需要 count - 1条线
        return count - 1;
    }

    public int find(int x, int[] parent){
        if (x != parent[x]){
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    public void union(int x, int y, int[] parent){
        parent[find(x, parent)] = parent[find(y, parent)];
    }
}
