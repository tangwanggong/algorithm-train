package day10;

import structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        // 先处理当前的左右两个子树
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        // 再处理左子树下面的
        invertTree(root.left);
        // 最后处理右子树
        invertTree(root.right);
        return root;
    }
}
