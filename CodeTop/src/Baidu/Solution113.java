package Baidu;

import Base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        pathSum(res, tmp, root, targetSum);
        return res;
    }

    public void pathSum(List<List<Integer>> res, List<Integer> tmp, TreeNode root, int targetSum){
        if (root == null) return;
        // 如果是叶子节点并且得到了目标值
        if (root.left == null && root.right == null){
            if (targetSum == root.val){
                List<Integer> list = new ArrayList<>(tmp);
                list.add(root.val);
                res.add(list);
            }
            return;
        }
        tmp.add(root.val);
        pathSum(res, tmp, root.left, targetSum - root.val);
        pathSum(res, tmp, root.right, targetSum - root.val);
        tmp.remove(tmp.size() - 1);
    }
}
