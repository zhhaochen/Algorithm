package JianZhi_Offer;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Solution18 {
    public void Mirror(TreeNode root) {
        if (root != null){
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}
