package Hot100;

import Top100.TreeNode;

public class Solution297 {
    // Encodes a tree to a single string.
    String SPLIT = ",";
    String NULL = "#";
    int index = 0;
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb){
        if (root ==  null){
            sb.append(NULL);
            sb.append(SPLIT);
            return;
        }
        sb.append(root.val);
        sb.append(SPLIT);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        index = 0;
        TreeNode root = deserialize(nodes);
        return root;
    }

    private TreeNode deserialize(String[] nodes){
        if (index >= nodes.length) return null;
        if (nodes[index].equals(NULL)){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nodes[index++]));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}
