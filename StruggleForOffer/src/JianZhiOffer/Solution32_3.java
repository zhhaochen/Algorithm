package JianZhiOffer;

import Base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        if (root != null) left.push(root);
        while (!left.isEmpty() || !right.isEmpty()){
            Stack<TreeNode> cur = left.isEmpty() ? right : left;
            Stack<TreeNode> next = left.isEmpty() ? left : right;
            int size = cur.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode node = cur.pop();
                tmp.add(node.val);
                // 区分先方左右
                if (cur == left){
                    if (node.left != null) next.push(node.left);
                    if (node.right != null) next.push(node.right);
                }else {
                    if (node.right != null) next.push(node.right);
                    if (node.left != null) next.push(node.left);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
