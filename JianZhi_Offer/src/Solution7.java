import node.TreeNode;

import java.util.Arrays;

/**
 * 面试七
 * 重建二叉树
 * 给出二叉树的前序遍历和中序遍历数组，且结果中不含重复数字，重建二叉树
 */
public class Solution7 {
    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        treeNode.preOrder();
    }
    // 方法1，没有用工具类
    //运行时间：320ms 占用内存：23804k
    private static TreeNode reConstructBinaryTree(int [] pre,int [] in){
        if (pre == null || in == null || pre.length != in.length || pre.length==0)
            return null;
        int index = pre.length -1;
        TreeNode head = reConstructBinaryChildTree(pre, 0, index,in, 0, index);
        return head;
    }

    private static TreeNode reConstructBinaryChildTree(int[] pre, int pre1, int pre2,
                                                       int[] in, int in1, int in2){
        TreeNode head = new TreeNode(pre[pre1]);
        if (pre1 == pre2)
            return head;
        int index = in1;
        //找到中序遍历的索引个索引
        for (; index<=in2; index++){
            if (in[index] == head.val) break; }
        //当有左子树的时候
        if (in1 != index){
            head.left = reConstructBinaryChildTree(pre, pre1+1, pre1+index-in1,
                    in, in1, index-1);
        }
        // 当有右子树的时候
        if (in2 != index){
            head.right = reConstructBinaryChildTree(pre, pre1+index-in1+1, pre2,
                    in, index+1, in2);
        }
        return head;
    }

    //原来使用了工具类的方法 运行时间：255ms 占用内存：23064k
    public TreeNode reConstructBinaryTree2(int [] pre,int [] in) {
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
        root.left = reConstructBinaryTree2(pre_left, in_left);
        root.right = reConstructBinaryTree2(pre_right, in_right);
        return root;
    }
}
