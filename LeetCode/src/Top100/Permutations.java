package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2020.09.09
 * Given a collection of distinct integers, return all possible permutations.
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        permute(nums);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> buf = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[i]);
            buf.add(tmp);
        }
        while (!buf.isEmpty()){
            List<Integer> tmp = buf.remove(0);
            if (tmp.size() == nums.length){
                res.add(tmp);
            }else {
                for (int i = 0; i < nums.length; i++){
                    // 注意这里是比较是否存在
                    if (!tmp.contains(nums[i])){
                        List<Integer> copy = tmp.stream().collect(Collectors.toCollection(ArrayList::new));
                        copy.add(nums[i]);
                        buf.add(copy);
                    }
                }
            }
        }
        return res;
    }
}
