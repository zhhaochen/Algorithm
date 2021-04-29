package ByteDance;

public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++){
            // 确定起点
            left[i] = gas[i] - cost[i];
        }
        for (int i = 0; i < n; i++){
            // 选中起点
            if (left[i] >= 0){
                if (check(left, i)) return i;
            }
        }
        return -1;
    }

    private boolean check(int[] nums, int index){
        int cur = 0;
        for (int i = index; i < index + nums.length; i++){
            cur += nums[i % nums.length];
            if (cur < 0) return false;
        }
        return true;
    }
}
