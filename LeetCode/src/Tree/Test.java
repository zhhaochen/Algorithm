package Tree;

import DFS_BFS.TreeNode;

public class Test {
    private TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(isValidBST(root.left)){
            if(pre != null && pre.val >= root.val) return false;
            pre = root;
            return(isValidBST(root.right));
        }
        return false;
    }
}
