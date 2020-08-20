package JianZhi_Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Solution60 {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> now = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        if(pRoot == null){
            return result;
        }
        queue.add(pRoot);
        int cur = 1;
        int next = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            cur--;
            now.add(node.val);
            if(node.left != null){
                queue.add(node.left);
                next++;
            }
            if(node.right != null){
                queue.add(node.right);
                next++;
            }

            if(cur == 0){
                result.add(now);
                now = new ArrayList<>();
                cur = next;
                next = 0;
            }
        }
        return result;
    }
}
