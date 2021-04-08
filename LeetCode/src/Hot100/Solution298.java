package Hot100;

import Top100.TreeNode;

public class Solution298 {
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        longestConsecutive(null, root, 0);
        return max;
    }

    private void longestConsecutive(TreeNode pre, TreeNode root, int length){
        if (root == null){
            max = Math.max(length, max);
            return;
        }
        if (pre == null) length = 1;
        else{
            if (root.val == pre.val + 1) length++;
            else {
                max = Math.max(length, max);
                length = 1;
            }
        }
        longestConsecutive(root, root.left, length);
        longestConsecutive(root, root.right, length);
    }
}
