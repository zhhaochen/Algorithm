import java.util.ArrayList;
import java.util.List;

public class Solution57_II {
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 2, sum;
        List<int[]> res = new ArrayList<>();
        while(right < target){
            sum = (left + right) * (right - left + 1) / 2;
            if (sum == target){
                int[] tmp = new int[right - left + 1];
                for (int i = left; i <= right; i++) tmp[i - left] = i;
                res.add(tmp);
                left++;
            }
            else if (sum < target) right++;
            else left++;
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] res = new Solution57_II().findContinuousSequence(9);
        System.out.println("");
    }
}
