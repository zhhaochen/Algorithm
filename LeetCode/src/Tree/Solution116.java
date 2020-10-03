package Tree;

/**
 * 2020.10.03
 * Populating Next Right Pointers in Each Node
 * 给定一棵树，把每一层用next指针向右连起来
 */
public class Solution116 {
    class Node{
        int val;
        Node left;
        Node right;
        Node next;
    }
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        connect(root.left, root.right);
        return root;
    }

    void connect(Node node1, Node node2){
        if(node1 == null || node2 == null){
            return;
        }
        node1.next = node2;
        connect(node1.left, node1.right);
        connect(node2.left, node2.right);
        connect(node1.right, node2.left);
    }
}
