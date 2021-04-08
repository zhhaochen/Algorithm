package Hot100;

import Top100.TreeNode;

public class Solution337 {
    public int rob(TreeNode root) {
        return rob(null, root);
    }

    // 返回当前子树是否打劫的最大值
    private int rob(TreeNode pre, TreeNode root){
        if (root == null) return 0;
        int cur = 0;
        // 父节点没有打劫，当前可以打劫
        if (pre == null){
            cur = root.val;
            // 接着向下打劫
            cur += rob(root, root.left);
            cur += rob(root, root.right);
        }
        // 当前节点不打劫
        cur = Math.max(cur, rob(null, root.left) + rob(null, root.right));
        return cur;
    }
}
