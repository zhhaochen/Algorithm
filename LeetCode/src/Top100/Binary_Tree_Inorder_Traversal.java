package Top100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 2020.09.11
 * 迭代实现二叉树中序遍历，不用递归
 */
public class Binary_Tree_Inorder_Traversal {
    // 第一种解法，破坏了树的结构
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            if (tmp.left != null){
                TreeNode left = tmp.left;
                // 将这个节点的左置为空，为了避免重复判断
                tmp.left = null;
                // 将这两个节点重新放入
                stack.push(tmp);
                stack.push(left);
            }else {
                res.add(tmp.val);
                if (tmp.right!=null){
                    stack.push(tmp.right);
                }
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        // 先判断 p是否为null，p为null时说明p指向了上一个字数的最右
        while (p != null || !stack.isEmpty()){
            // 把节点的所有左节点压入
            while (p != null){
                stack.push(p);
                p = p.left;
            }
            // 取出最左边的子树
            p = stack.pop();
            res.add(p.val);
            // 切换到右子树判断，此时可能为null，为null时说明当前这个子树遍历完了
            p = p.right;
        }
        return res;
    }
}
