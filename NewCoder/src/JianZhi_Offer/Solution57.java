package JianZhi_Offer;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Solution57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        //右子树不为空，找右子树的最左结点
        if(pNode.right != null){
            TreeLinkNode node = pNode.right;
            while(node.left!=null){
                node = node.left;
            }
            return node;
        }else{
            //否则，找到一个结点，他的父节点的左节点是本身
            while(pNode.next != null){
                TreeLinkNode parent = pNode.next;
                if(parent.left==pNode){
                    return parent;
                }
                pNode = pNode.next;
            }

        }
        return null;
    }
}
class TreeLinkNode{
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
