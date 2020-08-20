package tree;

public class TestBinaryTree {

    public static void main(String[] args) {
        //创建一棵树
        BinaryTree tree = new BinaryTree();
        //根节点
        TreeNode root = new TreeNode(1);
        tree.setRoot(root);
        TreeNode rootL = new TreeNode(2);
        TreeNode rootR = new TreeNode(3);
        root.setLeftNode(rootL);
        root.setRightNode(rootR);
        rootL.setLeftNode(new TreeNode(4));
        rootL.setRightNode(new TreeNode(5));
        rootR.setLeftNode(new TreeNode(6));
        rootR.setRightNode(new TreeNode(7));

        tree.preOrderTraversal();
        System.out.println();
        tree.sequentialTraversal();
        System.out.println();
        tree.postOrderShow();
        System.out.println();
        TreeNode result = tree.preOrderSearch(7);
        TreeNode result2 = tree.postOrderSearch(3);
        tree.delete(1);
        tree.delete(1);
        tree.postOrderShow();
    }

}
