package Top100;

import java.util.HashMap;
import java.util.Map;

/**
 * 2020.10.20
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * 1 <= n <= 19
 */
public class Unique_Binary_Search_Trees {
    Map<Integer, Integer> map = new HashMap<>();
    public int numTrees(int n) {
        return numTrees(1, n);
    }
    // 计算此范围内能组成几棵不同的二叉搜索树
    public int numTrees(int start, int end){
        if(start >= end){
            return 1;
        }
        // 因为 n 有范围限制，所以可以这样作为键，不然重复子问题太多，太慢
        if (map.containsKey(start * 19 + end)){
            return map.get(start * 19 + end);
        }
        int count = 0;
        for(int i = start; i <= end; i++){
            // 以当前节点为父节点，递归计算左右子树的个数，然后相乘
            // 递归就是要相信它，而不是管具体细节。递归自然而然会给完成
            int left = numTrees(start, i-1);
            int right = numTrees(i+1, end);
            count += left * right;
        }
        map.put(start * 19 + end, count);
        return count;
    }
}
