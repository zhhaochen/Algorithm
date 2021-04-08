import node.Node;

public class Solution36 {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        treeToDoublyList_(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void treeToDoublyList_(Node root){
        if (root == null) return;
        treeToDoublyList(root.left);
        if (pre == null) head = root;
        if (pre != null){
            pre.right = root;
            root.left = pre;
        }
        pre = root;
        treeToDoublyList(root.right);
    }
}
