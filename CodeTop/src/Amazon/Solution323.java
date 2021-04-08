package Amazon;

public class Solution323 {
    public int countComponents(int n, int[][] edges) {
        int[] union = new int[n];
        for (int i = 0; i < n; i++) union[i] = i;
        for (int[] edge : edges){
            Union(union, edge[0], edge[1]);
        }
        int res = 0;
        for (int i = 0; i < n; i++){
            if (union[i] == i) res++;
        }
        return res;
    }

    private int find(int[] union, int x){
        if (union[x] != x) union[x] = find(union, union[x]);
        return union[x];
    }

    private void Union(int[] union, int x, int y){
        int rootX = find(union, x);
        int rootY = find(union, y);
        if (rootX != rootY) union[rootX] = rootY;
    }
}
