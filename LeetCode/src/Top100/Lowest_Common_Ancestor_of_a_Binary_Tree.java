package Top100;

/**
 * 2020.11.16
 * 找两个节点的最低公共节点，节点可以是两个节点本身
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 */
public class Lowest_Common_Ancestor_of_a_Binary_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        // 本身就是可以直接返回
        if (root.val == p.val || root.val == q.val){
            return root;
        }
        // 判断左右子树的最低公共节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左右不为空则当前节点为最低公共
        if (left != null && right != null){
            return root;
        }
        // 否则鉴定是左子树的最低还是右子树的最低
        if (left != null){
            return left;
        }
        if (right != null){
            return right;
        }
        return null;
    }
}
