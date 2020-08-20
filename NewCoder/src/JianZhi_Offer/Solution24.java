package JianZhi_Offer;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Solution24 {

    //作为一个公共的调用
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        backtracking(root, target, new ArrayList<>());
        return res;
    }

    private void backtracking(TreeNode node, int target, ArrayList<Integer> path){
        if (node != null){
            path.add(node.val);
            target -= node.val; //用于记录当前的值
            if (target==0 && node.left ==null && node.right==null){
                res.add(new ArrayList<>(path));
            }else {
                backtracking(node.left, target, path);
                backtracking(node.right, target, path);
            }
            path.remove(path.size()-1); //把当前结点移除
        }
    }
}
