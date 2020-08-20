package tree;

public class TreeNode {

    private int value;
    private TreeNode leftNode;
    private TreeNode rightNode;

    public TreeNode(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }
}
