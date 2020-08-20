package tree;

public class TestArrayBinaryTree {
    public static void main(String[] args) {
        int[] tree = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(tree);
        arrayBinaryTree.frontShow();
    }

}
