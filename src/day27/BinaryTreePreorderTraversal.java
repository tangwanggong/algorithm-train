package day27;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @date 2022/4/29
 */
public class BinaryTreePreorderTraversal {


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root,result);
        return result;
    }

    public void helper(TreeNode root,List<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        helper(root.left,result);
        helper(root.right,result);
    }
}
