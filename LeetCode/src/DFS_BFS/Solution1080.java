package DFS_BFS;

/**
 * 2019.11.1
 * Insufficient Nodes in Root to Leaf Paths
 *
 * 给定一棵二叉树，当其中根节点到叶子结点的路径上所有的值相加比limit小时，则删除这条路径
 * 并不是每个结点都判断，只是根节点到叶子节点的路径
 */
public class Solution1080 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootL = new TreeNode(2);
        TreeNode rootR = new TreeNode(-3);
        TreeNode rootLL = new TreeNode(-5);
        TreeNode rootRL = new TreeNode(4);
        root.left = rootL;
        root.right = rootR;
        rootL.left = rootLL;
        rootR.left = rootRL;
        showNode(root);
        sufficientSubset(root, -1);
        showNode(root);
    }
    public static TreeNode sufficientSubset(TreeNode root, int limit){
        root = deleteNode(root, limit, 0);
        return root;
    }

    private static TreeNode deleteNode(TreeNode root, int limit, int curSum){
        if(root == null) return null;

        // 此时的节点为叶子几点时，计算是否小于limit
        if(root.left == null && root.right == null){
            if(curSum + root.val < limit)
                return null;
            else
                return root;
        }

        //判断当前节点到叶子节点的值是否小于limit，小于时将其删除
        root.left = deleteNode(root.left, limit, curSum + root.val);
        root.right = deleteNode(root.right, limit, curSum + root.val);

        // 当前节点经过判断后成为了叶子节点时，将其删除
        return (root.left == null && root.right == null) ? null : root;
    }

    private static void showNode(TreeNode root){
        System.out.print(root.val+" ");
        if (root.left != null){
            showNode(root.left);
        }
        if (root.right!=null){
            showNode(root.right);
        }
    }
}
