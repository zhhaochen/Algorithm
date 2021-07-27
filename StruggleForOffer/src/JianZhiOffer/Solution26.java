package JianZhiOffer;

import Base.TreeNode;

public class Solution26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return helper(A, B) | isSubStructure(A.left, B) | isSubStructure(A.right, B);
    }

    private boolean helper(TreeNode A, TreeNode B){
        if (A == null && B == null) return true;
        if (A == null) return false; // 说明 B 还有节点 A却没了，不是子结构
        if (B == null) return true; // 说明 B 已经没有节点了，是子结构
        if (A.val != B.val) return false;
        if (B.left == null && B.right == null) return true; // 叶子结点
        return helper(A.left, B.left) & helper(A.right, B.right);
    }
}
