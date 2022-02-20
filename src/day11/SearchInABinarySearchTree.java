package day11;

import structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 */
public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val < val){
            // 小于的话，就找右边节点
            return searchBST(root.right,val);
        }else if(root.val > val){
            // 同上
            return searchBST(root.left,val);
        }
        // 此时就相等了
        return root;
    }
}
