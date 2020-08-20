package JianZhi_Offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution59 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null){
            return result;
        }
        Stack<TreeNode>[] stacks = new Stack[]{new Stack(), new Stack()};
        ArrayList<Integer> level = new ArrayList<>();
        stacks[0].push(pRoot);
        int cur = 0;
        int next = 1;
        while (!stacks[0].isEmpty() || !stacks[1].isEmpty()){
            TreeNode node = stacks[cur].pop();
            level.add(node.val);
            //当前是奇数层时，按照左右顺序压入下一个栈
            if(cur == 0){
                if(node.left != null){
                    stacks[next].push(node.left);
                }
                if(node.right != null){
                    stacks[next].push(node.right);
                }
            }else{
                //当前是偶数层时，按照右左顺序压入下一个栈
                if(node.right != null){
                    stacks[next].push(node.right);
                }
                if(node.left != null){
                    stacks[next].push(node.left);
                }
            }
            if(stacks[cur].isEmpty()){
                result.add(level);
                level = new ArrayList<>();
                cur = 1-cur;
                next = 1-next;
            }

        }
        return result;
    }

}
