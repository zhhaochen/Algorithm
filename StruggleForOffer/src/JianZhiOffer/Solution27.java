package JianZhiOffer;

import Base.TreeNode;

public class Solution27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        // 左子树
        TreeNode right = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(right);
        return root;
    }
}
