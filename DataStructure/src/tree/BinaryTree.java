package tree;

import sun.reflect.generics.tree.Tree;

public class BinaryTree {

    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot(TreeNode root) {
        return root;
    }

    public void preOrderTraversal() {
        if (root != null) {
            preOrderTraversal_(root);
        }else {
            System.out.println("root is null");
        }
    }

    private void preOrderTraversal_(TreeNode root) {
        System.out.print(root.getValue() + " ");
        if (root.getLeftNode() != null) {
            preOrderTraversal_(root.getLeftNode());
        }
        if (root.getRightNode() != null) {
            preOrderTraversal_(root.getRightNode());
        }
    }

    public void sequentialTraversal() {
        if (root != null) {
            sequentialTraversal_(root);
        }else {
            System.out.println("root is null");
        }
    }

    private void sequentialTraversal_(TreeNode root) {
        if (root.getLeftNode() != null) {
            sequentialTraversal_(root.getLeftNode());
        }
        System.out.print(root.getValue() + " ");
        if (root.getRightNode() != null) {
            sequentialTraversal_(root.getRightNode());
        }
    }

    public void postOrderShow() {
        if (root != null) {
            postOrderShow_(root);
        }else {
            System.out.println("root is null");
        }
    }

    private void postOrderShow_(TreeNode root) {
        if (root.getLeftNode() != null) {
            postOrderShow_(root.getLeftNode());
        }
        if (root.getRightNode() != null) {
            postOrderShow_(root.getRightNode());
        }
        System.out.print(root.getValue() + " ");
    }

    //前序查找，中序后序类似
    public TreeNode preOrderSearch(int i) {
        if (root != null){
            return preOrderSearch(i, root);
        }
        else{
            System.out.println("root is null");
            return null;
        }
    }

    private TreeNode preOrderSearch(int i, TreeNode root) {
        TreeNode target = null;
        if (root.getValue() == i) {
            return root;
        } else {
            //查找左儿子
            if (root.getLeftNode() != null) {
                target = preOrderSearch(i, root.getLeftNode());
            }
            //看是否查到
            if (target != null) {
                return target;
            }
            //看右儿子
            if (root.getRightNode() != null) {
                target = preOrderSearch(i, root.getRightNode());
            }
        }
        return target;
    }

    //后序查找
    public TreeNode postOrderSearch(int i) {
        if (root != null){
            return postOrderSearch(i, root);
        }else {
            System.out.println("root is null");
            return null;
        }

    }

    private TreeNode postOrderSearch(int i, TreeNode root) {
        TreeNode target = null;
        //查找左儿子
        if (root.getLeftNode() != null) {
            target = postOrderSearch(i, root.getLeftNode());
        }
        //看是否查到
        if (target != null) {
            return target;
        }
        //看右儿子
        if (root.getRightNode() != null) {
            target = preOrderSearch(i, root.getRightNode());
        }
        //看是否查到
        if (target != null) {
            return target;
        }
        //最后看自己
        if (root.getValue() == i) {
            return root;
        }
        return target;
    }

    public void delete(int i) {
        if (root != null){
            if (root.getValue() == i){
                root = null;
                return;
            }
            delete_(i, root);
        }else {
            System.out.println("root is null");
        }
    }

    private void delete_(int i, TreeNode root) {
        //判断左儿子
        if (root.getLeftNode() != null && root.getLeftNode().getValue() == i) {
            root.setLeftNode(null);
            return;
        }
        //判断右儿子
        if (root.getRightNode() != null && root.getRightNode().getValue() == i) {
            root.setRightNode(null);
            return;
        }
        //递归检查并删除左儿子
        if (root.getLeftNode() != null) {
            delete_(i, root.getLeftNode());
        }
        //递归检查并删除右儿子
        if (root.getRightNode() != null) {
            delete_(i, root.getRightNode());
        }
    }
}
