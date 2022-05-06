package day28;

import structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 * @date 2022/5/6
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder,0,preorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode helper(int[] preorder, int preorderStart, int preorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
        if(preorderStart > preorderEnd){
            return null;
        }
        if(preorderStart == preorderEnd){
            return new TreeNode(preorder[preorderStart]);
        }

        TreeNode treeNode = new TreeNode(preorder[preorderStart]);
        int leftRootValue = preorder[preorderStart+1];
        int index = 0;
        for (int i = postorderStart; i <= postorderEnd; i++) {
            if(postorder[i] == leftRootValue){
                index = i;
                break;
            }
        }
        int leftLen = index - postorderStart + 1;

        treeNode.left = helper(preorder,preorderStart+1,preorderStart+leftLen,postorder,postorderStart,index);
        treeNode.right = helper(preorder,preorderStart+leftLen+1,preorderEnd,postorder,index+1,postorderEnd-1);

        return treeNode;
    }
}
