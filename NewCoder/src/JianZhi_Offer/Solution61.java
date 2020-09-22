package JianZhi_Offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Solution61 {
    String Serialize(TreeNode root) {
        return serialize(root, "");
    }

    TreeNode Deserialize(String str) {
        String[] data_array = str.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return deserialize(data_list);
    }
    // 前序遍历生成结果
    public String serialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += root.val + ",";
            str = serialize(root.left, str);
            str = serialize(root.right, str);
        }
        return str;
    }

    public TreeNode deserialize(List<String> l) {
        if (l.get(0).equals("None")) {
            l.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = deserialize(l);
        root.right = deserialize(l);

        return root;
    }
}
