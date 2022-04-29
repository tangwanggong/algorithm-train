package day27;

import structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * @date 2022/4/29
 */
public class DiameterOfBinaryTree {

    int max = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max - 1;
    }

    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        max = Math.max(max,leftMax+rightMax+1);
        return Math.max(leftMax,rightMax)+1;
    }
}
