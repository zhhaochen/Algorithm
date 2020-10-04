package Tree;

import DFS_BFS.TreeNode;

/**
 * 2020.10.04
 * Flatten Binary Tree to Linked List
 * Given a binary tree, flatten it to a linked list in-place.
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 1 ->2 ->3 ->4 ->5 ->6
 */
public class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        // 定义了递归，就相信递归，将左右子树拉平
        flatten(root.left);
        flatten(root.right);
        // 将左子树接到右子树
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        // 原右子树接到现在的末端
        TreeNode p = root.right;
        while (p.right != null){
            p = p.right;
        }
        p.right = right;
    }
}
