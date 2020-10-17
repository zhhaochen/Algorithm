package Top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2020.10.17
 * 二叉树层序遍历
 * 注意队列应该怎么写
 */
public class Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 记录当前层有多少节点
        int count = 1;
        TreeNode cur = null;
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            // 记录下一层有多少个节点
            int count_tmp = 0;
            for (int i = 0; i < count; i++){
                cur = queue.poll();
                if (cur.left != null){
                    queue.add(cur.left);
                    count_tmp++;
                }
                if (cur.right != null){
                    queue.add(cur.right);
                    count_tmp++;
                }
                tmp.add(cur.val);
            }
            count = count_tmp;
            res.add(tmp);
        }
        return res;
    }
}
