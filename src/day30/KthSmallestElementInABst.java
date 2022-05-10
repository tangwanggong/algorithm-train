package day30;

import structure.TreeNode;

/**
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 * @date 2022/5/10
 */
public class KthSmallestElementInABst {
    int result;
    int rank = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return result;
    }
    private void helper(TreeNode root, int k){
        if(root == null){
            return;
        }
        helper(root.left,k);
        rank++;
        if(rank == k){
            result = root.val;
            return;
        }
        helper(root.right,k);
    }
}
