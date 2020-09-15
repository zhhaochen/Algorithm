package Top100;

/**
 * 2020.09.15
 * 给定一棵二叉搜索树和一个值k，求这棵树中的第k小的值
 * k总是合法，k >= 1 && k <= 树的节点个数
 */
public class Kth_Smallest_Element_in_a_BST {
    public int kthSmallest(TreeNode root, int k) {
        // 根据二叉搜索树的性质，中序遍历即排序后的值
        int[] list = new int[k];
        in_order(list, 0, k, root);
        return list[k-1];
    }
    public int in_order(int[] list, int index, int k, TreeNode root){
        // 判断 index和 k的大小关系很关键
        if(root == null){
            return index;
        }
        if(index >= k){
            return index;
        }
        // 中序遍历
        if(root.left != null){
            index = in_order(list, index, k, root.left);
        }
        if(index >= k){
            return index;
        }
        list[index++] = root.val;
        if(root.right != null){
            index = in_order(list, index, k, root.right);
        }
        return index;
    }
}
