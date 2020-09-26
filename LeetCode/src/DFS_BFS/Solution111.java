package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2020.09.26
 * Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        // 队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // root本身就是一层，初始化为1
        int depth = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            // 把当前这一层的个数遍历出来，并将相邻的放入
            for (int i = 0; i < size; i++){
                TreeNode tmp = queue.poll();
                // 如果是叶子节点，就返回当前步数
                if (tmp.left == null && tmp.right==null){
                    return depth;
                }
                if (tmp.left != null){
                    queue.offer(tmp.left);
                }
                if (tmp.right != null){
                    queue.offer(tmp.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
