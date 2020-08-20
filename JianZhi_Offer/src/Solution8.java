import node.TreeNode;

/**
 * 面试八
 * 二叉树的下个节点
 * 给定二叉树和其中一个节点，找出中序遍历序列的下一个节点
 * 树中的节点除了左右节点还有父节点。
 */
public class Solution8 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        head.left = left;
        head.right = right;
        right.right = new TreeNode(3);
        right.right.parent = right;
        left.parent = head;
        right.parent = head;
        TreeNode treeNode = NextNodeInBinaryTrees(right.right);
        System.out.println(treeNode);
    }
    /**
     * 三种情况
     * 1、查询的节点含有右子树，则下一个节点是右子树的最左节点，这个节点不一定是叶子节点
     * 2、查询的节点不含右子树但是父节点的左节点，下一个节点就是父节点
     * 3、当既没有右子树又不是父节点的左节点，向上遍历，找到一个是父节点的左节点的节点，则那个父节点是下一个节点
     *    当找到最后节点的父节点为null时，说明这个节点没有下一个节点
     */
    public static TreeNode NextNodeInBinaryTrees(TreeNode node){
        if (node == null)
            return null;
        if (node.right != null){
            TreeNode point = node.right;
            while (point.left != null){
                point = point.left;
            }
            return point;
        }
        if (node.parent!=null && node == node.parent.left)
            return node.parent;
        TreeNode parent = node.parent;
        while (parent != null){
            if (parent == parent.left){
                return parent.parent;
            }else {
                parent = parent.parent;
            }
        }
        return parent;
    }
}
