package Amazon;

import Base.TreeNode;

public class Solution783 {
    TreeNode pre;
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        findMin(root);
        return min;
    }

    private void findMin(TreeNode root){
        if (root == null) return;
        findMin(root.left);
        if (pre != null) min = Math.min(min, root.val - pre.val);
        pre = root;
        findMin(root.right);
    }
}
