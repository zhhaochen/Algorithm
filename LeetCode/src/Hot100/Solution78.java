package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backtrack(res, tmp, nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int index){
        res.add(new ArrayList<>(tmp));
        if (index >= nums.length) return;
        for (int i = index; i < nums.length; i++){
            tmp.add(nums[i]);
            backtrack(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = new Solution78().subsets(nums);
        System.out.println(subsets);
    }
}
