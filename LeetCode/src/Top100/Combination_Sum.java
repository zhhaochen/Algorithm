package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Combination_Sum {
    // 起码自己想的解法，虽然又慢内存又大
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 先排序，为了避免后面出现[3, 4] [4, 3]的情况
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        // 缓存一下正在处理的结果
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i< candidates.length; i++){
            if(candidates[i] <= target){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(candidates[i]);
                list.add(tmp);
            }
        }
        while (!list.isEmpty()){
            // 每次获取第一个
            List<Integer> tmp = list.remove(0);
            long sum = tmp.stream().collect(Collectors.summarizingInt(value -> value)).getSum();
            if (sum == target){
                res.add(tmp);
                continue;
            }
            if (sum > target){
                continue;
            }
            for (int i = 0; i<candidates.length; i++){
                if (candidates[i] >= tmp.get(tmp.size() - 1)){
                    List<Integer> copy = tmp.stream().collect(Collectors.toCollection(ArrayList::new));
                    copy.add(candidates[i]);
                    list.add(copy);
                }
            }
        }
        return res;
    }
}
