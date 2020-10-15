package Top100;

/**
 * 2020.10.15
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class Maximum_Depth_of_Binary_Tree {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }
}
