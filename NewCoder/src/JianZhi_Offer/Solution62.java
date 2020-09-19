package JianZhi_Offer;

/**
 * 给定一棵二叉搜索树，输出第k小的节点
 */
public class Solution62 {
    TreeNode KthNode(TreeNode pRoot, int k){
        TreeNode[] res = new TreeNode[k];
        int index = putNode(pRoot, res, 0, k);
        // 判断是否超出范围，比如数的大小小于k或者找第0个大小节点
        if(k == 0 || index < k){
            return null;
        }
        return res[k-1];
    }
    // 不断进行更新索引
    int putNode(TreeNode root, TreeNode[] res, int index, int k){
        if(index >= k){
            return index;
        }
        // 中序遍历
        if(root == null){
            return index;
        }
        index = putNode(root.left, res, index, k);
        if(index >= k){
            return index;
        }
        res[index++] = root;
        index = putNode(root.right, res, index, k);
        return index;
    }
}
