package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2020.10.10
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        Arrays.sort(nums);
        subsets(res, track, nums);
        return res;
    }

    public void subsets(List<List<Integer>> res, List<Integer> track, int[] nums){
        // 存储当前结果
        res.add(new ArrayList<>(track));

        // 遍历选择列表
        for (int num : nums){
            if (track.size() == 0 || num > track.get(track.size() - 1)){
                // 做出选择
                track.add(num);
                // 进入下一层决策树
                subsets(res, track, nums);
                // 撤销选择
                track.remove(track.size()-1);
            }
        }
    }
}
