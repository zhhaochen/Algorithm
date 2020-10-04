package Tree;

import DFS_BFS.TreeNode;

/**
 * 2020.10.04
 * Construct Binary Tree from Preorder and Inorder Traversal
 * 从前序遍历与中序遍历恢复一棵二叉树
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length){
            return null;
        }
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder, int a1, int a2, int b1, int b2){
        if (a1 > a2){
            return null;
        }
        // 前序遍历的头
        TreeNode root = new TreeNode(preorder[a1]);
        // 找到中序遍历的左右
        int index = b1;
        for (; index <= b2; index++){
            if (inorder[index] == preorder[a1]){
                break;
            }
        }
        // 找到前序遍历的左右，根据长度来
        int len = index - b1;
        // 左子树
        root.left = buildTree(preorder, inorder, a1+1, a1+len, b1, index - 1);
        // 右子树
        root.right = buildTree(preorder, inorder, a1 + len + 1, a2, index+1, b2);
        return root;
    }
}
