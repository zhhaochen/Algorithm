package Top100;

import java.util.HashSet;
import java.util.Set;

/**
 * 2020.12.02
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * Follow up: Could you implement the O(n) solution?
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) s.add(num);
        int res = 0;
        for (int num : nums){
            if (s.remove(num)){
                int pre = num - 1, next = num + 1;
                while (s.remove(pre)) pre--;
                while (s.remove(next)) next++;
                res = Math.max(res, next - pre - 1);
            }
        }
        return res;
    }
}
