package Tree;

import DFS_BFS.TreeNode;

/**
 * 2020.10.04
 * Maximum Binary Tree
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 *      The root is the maximum number in the array.
 *      The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 *      The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 */
public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end){
        if (start > end){
            return null;
        }
        int index = start;
        int max = nums[start];
        for (int i = start+1; i <= end; i++){
            if (nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(nums, start, index-1);
        root.right = constructMaximumBinaryTree(nums, index+1, end);
        return root;
    }
}
