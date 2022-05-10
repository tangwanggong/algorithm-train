package day30;

import structure.TreeNode;

/**
 * https://leetcode.cn/problems/convert-bst-to-greater-tree/
 * @date 2022/5/10
 */
public class ConvertBstToGreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root != null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
            return root;
        }
        return root;
    }


}
