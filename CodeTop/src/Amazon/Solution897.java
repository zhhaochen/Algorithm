package Amazon;

import Base.TreeNode;

public class Solution897 {
    TreeNode head, tail;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return root;
        // the tail of the left
        increasingBST_(root);
        return head;
    }

    public void increasingBST_(TreeNode root){
        if (root == null) return;
        // find the head of the list
        if (root.left == null && head == null) head = root;
        increasingBST_(root.left);
        if (tail != null) tail.right = root;
        root.left = null;
        tail = root;
        increasingBST_(root.right);
    }
}
