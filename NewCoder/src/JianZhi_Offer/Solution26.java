package JianZhi_Offer;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Solution26 {
    private TreeNode pre = null;
    private TreeNode head = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        //根据二叉搜索树的性质，中序遍历能得到排序后的结果
        inOrder(pRootOfTree);
        return head;
    }

    //按照中序遍历的顺序处理
    private void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left); //处理左子树，pre最终此时指向了尾结点
        node.left = pre; //将自己指向左结点
        if (pre != null) //如果这个结点不是null
            pre.right = node; //指向node结点，双向链表
        pre = node; //将pre指向node
        if (head == null) //调整head指向最小值的结点。
            head = node;
        inOrder(node.right);
    }
}
