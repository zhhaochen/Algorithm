package Depth_First_Search;

public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        // 特殊情况，输入了一个空的树
        if (root==null){
            return true;
        }
        //判断是否为叶子节点
        if (root.left==null&&root.right==null){
            return true;
        }//当是一个左右都有的叶子节点时
        else if (root.right!=null&&root.left!=null){
            if (root.left.val<root.val&&root.right.val>root.val){
                return true&&isValidBST(root.left)&&isValidBST(root.right);
            }else {
                return false;
            }
        }else if (root.left!=null){
            if (root.left.val<root.val){
                return true&&isValidBST(root.left)&&isValidBST(root.right);
            }else {
                return false;
            }
        }else{
            if (root.right.val>root.val){
                return true&&isValidBST(root.left)&&isValidBST(root.right);
            }else {
                return false;
            }
        }
    }
}
