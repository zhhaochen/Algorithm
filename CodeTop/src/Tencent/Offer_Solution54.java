package Tencent;

import Base.TreeNode;

import java.util.Stack;

public class Offer_Solution54 {
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        // 右 -> 中 -> 左
        TreeNode p = root;
        while (p != null || !stack.isEmpty()){
            while (p != null){
                stack.push(p);
                p = p.right;
            }
            // 拿出一个节点
            if (!stack.isEmpty()){
                p = stack.pop();
                if (k == 1) return p.val;
                k--;
                p = p.left;
            }
        }
        return 0;
    }

    public static TreeNode buildTree(String[] nums, int index){
        if (index >= nums.length) return null;
        if (nums[index].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(nums[index]));
        root.left = buildTree(nums, 2 * index + 1);
        root.right = buildTree(nums, 2 * index + 2);
        return root;
    }

    public static void main(String[] args) {
        String roots = "41,37,44,24,39,42,48,1,35,38,40,null,43,46,49,0,2,30,36,null,null,null,null,null,null,45,47,null,null,null,null,null,4,29,32,null,null,null,null,null,null,3,9,26,null,31,34,null,null,7,11,25,27,null,null,33,null,6,8,10,16,null,null,null,28,null,null,5,null,null,null,null,null,15,19,null,null,null,null,12,null,18,20,null,13,17,null,null,22,null,14,null,null,21,23";
        String[] nums = roots.split(",");
        TreeNode root = buildTree(nums, 0);
        int res = new Offer_Solution54().kthLargest(root, 25);
        System.out.println(res);
    }
}
