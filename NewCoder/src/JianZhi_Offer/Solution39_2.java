package JianZhi_Offer;

// 39题的比较复杂做法，多次重复调用了深度计算函数
public class Solution39_2 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right) && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1) {
            return true;
        }
        return false;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return 1 + Math.max(left, right);
    }
}
