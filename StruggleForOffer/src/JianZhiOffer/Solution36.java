package JianZhiOffer;

public class Solution36 {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        helper(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void helper(Node root){
        if (root == null) return;
        helper(root.left);
        if (pre != null){
            root.left = pre;
            pre.right = root;
        }else head = root;
        pre = root;
        helper(root.right);
    }
}

class Node{
    int val;
    Node left;
    Node right;
    Node(int x){
        this.val = x;
    }
}
