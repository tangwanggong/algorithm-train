package day11;

import structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }

    /**
     * @param root 根节点
     * @param min 最小值节点
     * @param max 最大值节点
     * @return
     */
    private boolean helper(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null){
            return true;
        }
        // 当最小值节点不为空时，所有节点值都要小于它
        if(min != null && min.val >= root.val){
            return false;
        }
        // 同上
        if(max != null && max.val <= root.val){
            return false;
        }
        // 左节点，最大值为root节点，当处理左节点的左子节点时，最大值还是当前root，不用特殊处理，处理左子节点的右子节点时，需要传入根节点做判断
        return helper(root.left,min,root)
                // 同上
                && helper(root.right,root,max);
    }
}
