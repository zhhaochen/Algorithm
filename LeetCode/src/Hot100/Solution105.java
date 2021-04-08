package Hot100;

import Top100.TreeNode;

public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int leftPre, int rightPre, int leftIn, int rightIn){
        if (leftPre > rightPre) return null;
        TreeNode root = new TreeNode(preorder[leftPre]);
        int mid = leftIn;
        while (mid <= rightIn){
            if (inorder[mid] == root.val) break;
            mid++;
        }
        root.left = buildTree(preorder, inorder, leftPre + 1, leftPre + mid - leftIn , leftIn, mid - 1);
        root.right = buildTree(preorder, inorder, rightPre - rightIn + mid + 1, rightPre, mid + 1, rightIn);
        return root;
    }
}
