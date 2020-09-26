package Challenge_30_Day.May.week5;

import DFS_BFS.TreeNode;

import java.util.Stack;

public class Binary_Tree_Maximum_Path_Sum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));
    }
    public static int maxPathSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            int leftW = 0;
            int rightW = 0;
            if (pop.left != null) {
                stack.push(pop.left);
                leftW = Math.max(leftW,getWeight(pop.left)); //左子树的最大权重
            }
            if (pop.right != null) {
                stack.push(pop.right);
                rightW = Math.max(rightW, getWeight(pop.right)); //右子树的最大权重
            }
            int weight = pop.val + leftW + rightW;
            max =  Math.max(max, weight);
        }
        return max;
    }

    private static int getWeight(TreeNode node){
        int left = 0;
        int right = 0;
        if (node.left != null){
            left = Math.max(getWeight(node.left), 0);
        }
        if (node.right != null){
            right = Math.max(getWeight(node.right), 0);
        }
        return node.val + Math.max(left, right);
    }
}
