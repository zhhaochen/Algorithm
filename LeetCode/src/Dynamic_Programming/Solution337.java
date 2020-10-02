package Dynamic_Programming;

import DFS_BFS.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2020.10.02
 * House Robber III
 * 房子是二叉树，同样不能抢相邻的
 * Input: [3,2,3,null,3,null,1]
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 */
public class Solution337 {
    private Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        // 抢，然后去下下家
        int rob_it = root.val +
                ((root.left == null) ? 0 : rob(root.left.left) + rob(root.left.right)) +
                ((root.right == null) ? 0 : rob(root.right.left) + rob(root.right.right));
        // 不抢，然后去下家
        int not_rob = rob(root.left) + rob(root.right);
        int res = Math.max(rob_it, not_rob);
        memo.put(root, res);
        return res;
    }
    // 大神解法，效率贼高，内存贼小
    public int rob_dp(TreeNode root){
        if (root == null){
            return 0;
        }
        int[] res = rob_dp_(root);
        return Math.max(res[0], res[1]);
    }
    // 返回一个二维数组，0代表抢，1代表不抢
    public int[] rob_dp_(TreeNode root){
        if (root == null){
            return new int[]{0, 0};
        }
        int[] left = rob_dp_(root.left);
        int[] right = rob_dp_(root.right);
        // 抢，下家不抢
        int rob = root.val + left[1] + right[1];
        // 不抢，下家可抢可不抢
        int not_rob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{rob, not_rob};
    }
}
