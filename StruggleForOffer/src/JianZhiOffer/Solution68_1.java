package JianZhiOffer;

import Base.TreeNode;

public class Solution68_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        else if (left != null || right != null) return left != null ? left : right;
        return null;
    }
    public TreeNode lowestCommonAncestor_best(TreeNode root, TreeNode p, TreeNode q) {
        // 利用二叉搜索树性质
        TreeNode head = root;
        while (true){
            if (head.val < p.val && head.val < q.val) head = head.right;
            else if (head.val > p.val && head.val > q.val) head = head.left;
            else break;
        }
        return head;
    }
}
