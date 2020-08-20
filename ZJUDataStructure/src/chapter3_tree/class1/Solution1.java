package chapter3_tree.class1;

import java.util.Stack;

/**
 * 用堆栈实现二叉树的前序、中序、后序遍历
 */
public class Solution1 {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>(1);
        tree.left = new BinaryTreeNode<>(2);
        tree.right = new BinaryTreeNode<>(3);
        tree.left.left = new BinaryTreeNode<>(4);
        tree.left.right = new BinaryTreeNode<>(5);
        tree.right.right = new BinaryTreeNode<>(6);
        tree.left.right.left = new BinaryTreeNode<>(7);
        tree.left.right.left.right = new BinaryTreeNode<>(8);
//        inOrderTraversal(tree);
//        System.out.println();
//        preOrderTraversal(tree);
//        System.out.println();
        postOrderTraversal(tree);
    }
    //中序遍历
    public static void inOrderTraversal(BinaryTreeNode<Integer> node){
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode TMP = node;
        while (TMP!=null || !stack.isEmpty()){
            while (TMP!=null){
                stack.push(TMP);
                TMP = TMP.left;
            }
            if (!stack.isEmpty()){
                TMP = stack.pop();
                System.out.print(TMP.data+ " ");
                TMP = TMP.right;
            }
        }
    }

    //前序遍历
    public static void preOrderTraversal(BinaryTreeNode<Integer> node){
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode TMP = node;
        while (TMP!=null || !stack.isEmpty()){
            while (TMP!=null){
                stack.push(TMP);
                System.out.print(TMP.data+ " ");
                TMP = TMP.left;
            }
            if (!stack.isEmpty()){
                TMP = stack.pop();
                TMP = TMP.right;
            }
        }
    }

    //后序遍历
    public static void postOrderTraversal(BinaryTreeNode<Integer> node){
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode TMP = node;
        BinaryTreeNode OUTED = node;
        while (TMP!=null || !stack.isEmpty()){
            while (TMP!=null){
                stack.push(TMP);
                TMP = TMP.left;
            }
            if (!stack.isEmpty()){
                TMP = stack.pop();
                //如果没有右子树或者右子树已经输出过
                if (TMP.right == null || OUTED==TMP.right){
                    System.out.print(TMP.data+ " ");
                    OUTED = TMP;
                    TMP = null; //此时输出了中间的结点，置为null为了下一步从stack中取值
                }else { //如果右子树还没输出过
                    stack.push(TMP);
                    TMP = TMP.right; //因为右子树没有输出过，当前节点入栈，进行右子树判别
                }
            }
        }
    }
}

//自定义二叉树
class BinaryTreeNode<T>{
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T data){
        this.data = data;
    }
}
