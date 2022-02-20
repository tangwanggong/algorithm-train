package day10;

import structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        // 先处理左右子树
        flatten(root.left);
        flatten(root.right);
        // 处理完成之后,左右子树都是展开的
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 左子树变成右子树
        root.left = null;
        root.right = left;
        // 右子树接到右子树的末端
        TreeNode p = root;
        while (p.right != null){
            p = p.right;
        }
        p.right = right;
    }
}
