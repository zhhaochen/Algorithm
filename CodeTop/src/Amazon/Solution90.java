package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        res.add(new ArrayList<>(tmp));
        boolean[] visit = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, 0, visit, tmp, res);
        return res;
    }

    private void backtrack(int[] nums,int index, boolean[] visit, List<Integer> tmp, List<List<Integer>> res){
        if (tmp.size() != 0) res.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; i++){
            if (!visit[i] && (i == 0 || nums[i-1] != nums[i] || visit[i-1])){
                tmp.add(nums[i]);
                visit[i] = true;
                backtrack(nums, i + 1, visit, tmp, res);
                visit[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
