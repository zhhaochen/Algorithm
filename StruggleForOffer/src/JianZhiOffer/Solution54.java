package JianZhiOffer;

import Base.TreeNode;

public class Solution54 {
    TreeNode pre, res; int k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        helper(root);
        return res.val;
    }
    private void helper(TreeNode root){
        if (root == null || k == 0) return;
        helper(root.right);
        if (k == 1) res = root;
        k--;
        pre = root;
        helper(root.left);
    }
}
