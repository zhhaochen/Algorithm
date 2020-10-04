package Tree;

import DFS_BFS.TreeNode;

/**
 * 2020.10.04
 * Construct Binary Tree from Inorder and Postorder Traversal
 * 中序遍历和后序遍历重建二叉树
 */
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length){
            return null;
        }
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd){
        if(inStart > inEnd){
            return null;
        }
        int index = inStart;
        for(; index <= inEnd; index++){
            if(inorder[index] == postorder[postEnd]){
                break;
            }
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int len = index - inStart;
        root.left = buildTree(inorder, postorder, inStart, index - 1, postStart, postStart+len -1);
        root.right = buildTree(inorder, postorder, index + 1, inEnd, postStart+len, postEnd-1);
        return root;
    }
}
