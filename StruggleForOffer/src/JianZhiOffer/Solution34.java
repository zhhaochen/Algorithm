package JianZhiOffer;

import Base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        helper(root, target, tmp, res);
        return res;
    }

    private void helper(TreeNode root, int target, List<Integer> tmp, List<List<Integer>> res){
        if (root == null) return;
        tmp.add(root.val);
        if (root.left == null && root.right == null){
            if (root.val == target){
                res.add(new ArrayList<>(tmp));
            }
        }else {
            if (root.left != null) helper(root.left, target - root.val, tmp, res);
            if (root.right != null) helper(root.right, target - root.val, tmp, res);
        }
        tmp.remove(tmp.size() - 1);
    }
}
