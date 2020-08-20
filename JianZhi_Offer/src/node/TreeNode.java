package node;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public TreeNode(int x){
        this.val = x;
    }

    public void preOrder(){
        System.out.print(this.val + " ");
        if (left != null){
            left.preOrder();
        }
        if (right != null){
            right.preOrder();
        }
    }
}
