package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        backtrack(res, tmp, nums, visited);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int[] visited){
        if(tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i] == 0){
                // 只有当前一个与自己相同的进入了排列才可以继续
                if(i > 0 && nums[i-1] == nums[i] && visited[i-1] == 0) continue;
                tmp.add(nums[i]);
                visited[i] = 1;
                backtrack(res, tmp, nums, visited);
                tmp.remove(tmp.size()-1);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        new Solution47().permuteUnique(nums);
    }
}
