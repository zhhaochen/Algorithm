package Top100;

/**
 * 2020.11.26
 * 对一棵二叉树编码为字符串，然后能将字符串解码一棵二叉树
 */
public class Serialize_and_Deserialize_Binary_Tree {
    String SEP = ",";
    String NULL = "#";
    int index;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(SEP);
        index = 0;
        return deserialize(nodes);
    }
    public TreeNode deserialize(String[] nodes){
        if (index >= nodes.length){
            return null;
        }
        if (nodes[index].equals("#")){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nodes[index++]));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}
