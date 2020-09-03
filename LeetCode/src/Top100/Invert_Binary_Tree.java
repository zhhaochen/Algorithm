package Top100;

/**
 * 2020.09.03
 * 反转二叉树
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        // 后序遍历
        invertTree(root.left);
        invertTree(root.right);
        TreeNode p = root.left;
        root.left = root.right;
        root.right = p;
        return root;
    }
}
