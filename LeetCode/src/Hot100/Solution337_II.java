package Hot100;

import Top100.TreeNode;

public class Solution337_II {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    // 返回当前子树是否打劫的最大值
    private int[] dfs(TreeNode root){
        if (root == null) return new int[]{0, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        // 当前节点被选择
        int select = root.val + left[1] + right[1];
        // 当前节点不被选择，左右节点可选可不选，选最大的，自底向上
        int noSelect = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{select, noSelect};
    }
}
