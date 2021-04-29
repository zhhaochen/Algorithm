package Microsoft;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 桶排序
        Map<Integer, Integer> map = new HashMap<>();
        // 桶的个数，因为要把每个数表示成 nums[i] = a * t + b (0 <= b <= t)
        // 则每个桶内的数之间相差肯定小于t
        int w = t + 1;
        for (int i = 0; i < nums.length; i++){
            int id = getId(nums[i], w);
            if (map.containsKey(id) && Math.abs(map.get(id) - i) <= k) return true;
            // 看之前的
            if (map.containsKey(id - 1)){
                int pre = map.get(id - 1);
                if (((long)nums[i] - (long) nums[pre]) <= t && Math.abs(i - pre) <= k) return true;
            }
            // 看之后的
            if (map.containsKey(id + 1)){
                int next = map.get(id + 1);
                if (((long)nums[next] - (long) nums[i]) <= t && Math.abs(i - next) <= k) return true;
            }
            map.put(id, i);
        }
        return false;
    }

    // 为了区分桶
    // 比如给定的 t = 2，则 w = 3，w即每个桶包含元素的数量
    // 例如 0,1,2 都会在 0 桶中，桶中元素相差不超过2
    // 如果是负数，-1 -2 -3 都会在 - 1桶中
    // 非负数用 num / w 主要是为了非负数第一个桶是从多少开始
    // 如果互换，非负数用(num - 1) / w + 1，则第一个桶从 1 开始；负数用num/w，则第一个从0开始
    private int getId(int num, int w){
        if (num >= 0) return num / w;
        return (num + 1) / w - 1;
    }
}
