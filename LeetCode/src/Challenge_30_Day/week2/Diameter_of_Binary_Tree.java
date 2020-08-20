package Challenge_30_Day.week2;

import java.util.Stack;

/**
 * 找出二叉树任意两个结点的最长路径
 *    1
 *   / \
 *   2  3
 *  / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 */
public class Diameter_of_Binary_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        //即找出一个结点，他的左右子树高度之和最大。
        int max = 0;
        if (root==null){
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            int leftL = 0;
            int rightL = 0;
            if (pop.left != null) {
                stack.push(pop.left);
                leftL += getHight(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
                leftL += getHight(pop.right);
            }
            max = max > rightL + leftL ? max : rightL + leftL;
        }
        return max;
    }

    private static int getHight(TreeNode root) {
        int leftL = 0;
        int rightL = 0;
        if (root.left != null) {
            leftL += getHight(root.left);
        }
        if (root.right != null) {
            rightL += getHight(root.right);
        }
        return rightL > leftL ? rightL + 1 : leftL + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
