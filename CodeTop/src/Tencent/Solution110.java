package Tencent;

import Base.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root){
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (right == -1 || left == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
