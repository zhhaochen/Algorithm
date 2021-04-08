package Baidu;

import Base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution144_II {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    public void preorderTraversal(TreeNode root, List<Integer> res){
        if (root == null) return;
        res.add(root.val);
        preorderTraversal(root.left, res);
        preorderTraversal(root.right, res);
    }
}
