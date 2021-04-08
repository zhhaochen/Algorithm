package UnionFind;

import java.util.HashSet;
import java.util.Set;

public class Solution547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (isConnected[i][j] == 1) union(i, j, parent);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++){
            if (i == parent[i])count++;
        }
        return count;
    }

    public int find(int x, int[] parent){
        if (x != parent[x]){
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
    public void union(int x, int y, int[] parent){
        int rootX = find(x, parent);
        int rootY = find(y, parent);
        if (rootX == rootY) return;
        parent[rootX] = rootY;
    }
}
