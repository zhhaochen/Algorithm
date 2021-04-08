package Hot100;

import Top100.TreeNode;

public class Solution543 {
    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        solution(root);
        return max;
    }

    private int solution(TreeNode root){
        if (root == null) return 0;
        int left = solution(root.left);
        int right = solution(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
