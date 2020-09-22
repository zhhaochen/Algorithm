package JianZhi_Offer;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class Solution39 {
    public boolean IsBalanced_Solution(TreeNode root) {
        return getHeight(root) != -1;
    }
    // 简单方法，用-1来表示是否不是平衡二叉树
    public int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = getHeight(root.left);
        if (left == -1) return -1;
        int right = getHeight(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
