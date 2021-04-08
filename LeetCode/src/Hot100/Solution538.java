package Hot100;

import Top100.TreeNode;

public class Solution538 {
    int cur = 0;
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    private void convert(TreeNode root){
        if (root == null) return;
        convert(root.right);
        root.val += cur;
        cur = root.val;
        convert(root.left);
    }
}
