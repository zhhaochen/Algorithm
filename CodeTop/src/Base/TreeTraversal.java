package Base;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 二叉树前序、中序、后续、层序遍历总结
public class TreeTraversal {
    // 二叉树前序遍历递归法
    public void preorderTraversalI(TreeNode root){
        if (root == null)return;
        System.out.println(root.val);
        preorderTraversalI(root.left);
        preorderTraversalI(root.right);
    }
    // 二叉树前序遍历非递归法
    public void preorderTraversalII(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()){
            while (p != null){
                System.out.println(p.val);
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()){
                p = stack.pop().right;
            }
        }
    }

    // 二叉树中序遍历递归法
    public void inorderTraversalI(TreeNode root) {
        if (root == null) return;
        inorderTraversalI(root.left);
        System.out.println(root.val);
        inorderTraversalI(root.right);
    }

    // 二叉树中序遍历非递归法
    public void inorderTraversalII(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()){
            while (p != null){
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()){
                p = stack.pop();
                System.out.println(p.val);
                p = p.right;
            }
        }
    }

    // 二叉树后序遍历递归法
    public void postorderTraversalI(TreeNode root){
        if (root == null) return;
        postorderTraversalI(root.left);
        postorderTraversalI(root.right);
        System.out.println(root.val);
    }

    // 二叉树后序遍历非递归法
    public void postorderTraversalII(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root, pre = null;
        while (p != null || !stack.isEmpty()){
            while (p != null){
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()){
                // 弹出当前的节点
                p = stack.pop();
                // todo 判断右子树是否已经访问过或者是否为空
                if (pre == p.right || p.right == null){
                    System.out.println(p.val);
                    pre = p;
                    p = null;
                }else{
                    stack.push(p);
                    pre = p.right;
                }
            }
        }
    }
    // 二叉树层序遍历
    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            System.out.println(p.val);
            if (p.left != null) queue.offer(p.left);
            if (p.right != null) queue.offer(p.right);
        }
    }
}
