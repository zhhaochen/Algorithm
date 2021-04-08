import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution61 {
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = 14, max = 0;
        for (int num : nums){
            if (num == 0) continue;
            if (set.contains(num)) return false;
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return max - min < 5;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 2, 2, 5};
        boolean res = new Solution61().isStraight(nums);
        System.out.println(res);
    }
}
