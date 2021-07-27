package JianZhiOffer;

import Base.TreeNode;

public class Solution7 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight){
        if (preLeft > preRight) return null;
        TreeNode root = new TreeNode(preorder[preLeft]);
        // 找到中序遍历的索引
        int index = inLeft;
        for (; index <= inRight; index++){
            if (inorder[index] == root.val) break;
        }
        root.left = buildTree(preorder, inorder, preLeft + 1, preLeft + index - inLeft, inLeft, index - 1);
        root.right = buildTree(preorder, inorder, preLeft + index - inLeft + 1, preRight, index + 1, inRight);
        return root;
    }
}
