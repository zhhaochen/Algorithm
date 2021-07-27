package JianZhiOffer;

import Base.TreeNode;

public class Solution37 {
    int index;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append('#');
            sb.append(',');
            return;
        }
        sb.append(root.val);
        sb.append(',');
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;
        String[] nodes = data.split(",");
        return deserialize(nodes);
    }

    private TreeNode deserialize(String[] nodes){
        if (index >= nodes.length) return null;
        String cur = nodes[index++];
        if (cur.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }

    public static void main(String[] args) {
        String data = "1,2,#,#,3,4,#,#,5,#,#";
        TreeNode root = new Solution37().deserialize(data);
    }
}
