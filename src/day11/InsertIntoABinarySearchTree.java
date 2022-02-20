package day11;

import structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 */
public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 如果节点为空，就可以插入值为val的子节点了
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val < val){
            // 小于的话，就处理右边节点，如果右边节点为null，就插入了，不为null，就往下找子节点为null的节点插入，就可以平衡了
            root.right = insertIntoBST(root.right,val);
        }else if(root.val > val){
            // 同上
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }
}
