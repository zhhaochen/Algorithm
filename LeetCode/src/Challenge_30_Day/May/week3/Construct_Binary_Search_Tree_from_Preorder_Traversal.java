package Challenge_30_Day.May.week3;

import Depth_First_Search.TreeNode;

public class Construct_Binary_Search_Tree_from_Preorder_Traversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0){
            return null;
        }
        TreeNode head = new TreeNode(preorder[0]);
        for (int i=1; i<preorder.length; i++){
            TreeNode tmp = head;
            TreeNode parent = head;
            while (tmp!=null){
                parent = tmp;
                if (tmp.val < preorder[i]){
                    tmp = tmp.right;
                }else {
                    tmp = tmp.left;
                }
            }
            if (parent.val < preorder[i]){
                parent.right = new TreeNode(preorder[i]);
            }else {
                parent.left = new TreeNode(preorder[i]);
            }
        }
        return head;
    }
}
