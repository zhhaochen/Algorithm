package Top100;

/**
 * 2020.10.23
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 *   The left subtree of a node contains only nodes with keys less than the node's key.
 *   The right subtree of a node contains only nodes with keys greater than the node's key.
 *   Both the left and right subtrees must also be binary search trees.
 *
 */
public class Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max){
        if(root == null){
            return true;
        }
        if(min != null && min.val >= root.val) return false;
        if(max != null && max.val <= root.val) return false;
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
