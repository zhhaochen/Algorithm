package JianZhi_Offer;

import java.util.Arrays;

/**
 * 2019.11.10
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Solution4 {
    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 3, 5, 6};
        int[] in = new int[]{4, 2, 1, 5, 3, 6};
        TreeNode root = reConstructBinaryTree(pre, in);
    }
    //主要是一个寻找子树的root点的过程
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int len = pre.length;
        if(len == 0)
            return null;
        TreeNode root = new TreeNode(pre[0]);
        int index = 0;
        for (; index<len; index++)
            if (pre[0] == in[index])
                break;
        int[] pre_left = Arrays.copyOfRange(pre, 1, index+1); //获取pre左子树
        int[] pre_right = Arrays.copyOfRange(pre, index+1, len); //获取pre右子树
        int[] in_left = Arrays.copyOfRange(in, 0, index); //获取in左子树
        int[] in_right = Arrays.copyOfRange(in, index+1, len); //获取in右子树
        root.left = reConstructBinaryTree(pre_left, in_left);
        root.right = reConstructBinaryTree(pre_right, in_right);
        return root;
    }
}
