package Hot100;

import Top100.TreeNode;

import java.util.Stack;

public class Solution114 {
    TreeNode tail = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null){
            tail = root;
            return;
        }
        TreeNode right = root.right;
        flatten(root.left);
        if (tail != null){
            root.right = root.left;
            root.left = null;
            tail.right = right;
            if (tail.right != null )tail = null;
        }
        flatten(right);
    }
}
