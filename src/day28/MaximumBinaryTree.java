package day28;

import structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 * @date 2022/5/6
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if(start > end){
            return null;
        }
        int maxValue = nums[start];
        int index = start;
        for (int i = start+1; i <= end ; i++) {
            if(maxValue < nums[i]){
                maxValue = nums[i];
                index = i;
            }
        }
        TreeNode treeNode = new TreeNode(maxValue);
        treeNode.left = helper(nums,start,index-1);
        treeNode.right = helper(nums,index+1,end);
        return treeNode;
    }
}
