package Challenge_30_Day.week7;

public class Flood_Fill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        if (target != newColor){ //如果相等会陷入死循环
            dfs(image, sr, sc, target, newColor);
        }
        return image;
    }

    private void dfs(int[][]imgae, int i, int j, int target, int newColor){
        if (i >= 0 && i < imgae.length && j >=0 && j < imgae[0].length){
            if (imgae[i][j] == target){
                imgae[i][j] = newColor;
                dfs(imgae, i-1, j, target, newColor);
                dfs(imgae, i+1, j, target, newColor);
                dfs(imgae, i, j-1, target, newColor);
                dfs(imgae, i, j+1, target, newColor);
            }
        }
    }
}
