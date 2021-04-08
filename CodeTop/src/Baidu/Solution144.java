package Baidu;

import Base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()){
            // 左子树一直遍历
            while (p != null){
                list.add(p.val);
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()){
                p = stack.pop().right;
            }
        }
        return list;
    }
}
