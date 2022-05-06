package day28;

import structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @date 2022/5/6
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd) {
        if(preorderStart > preorderEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderStart]);

        int index = 0;
        for (int i = inorderStart; i <= inorderEnd ; i++) {
            if(inorder[i] == preorder[preorderStart]){
                index = i;
                break;
            }
        }
        int leftLen = index - inorderStart;

        root.left = helper(preorder,preorderStart + 1,preorderStart + leftLen,inorder,inorderStart,index-1);
        root.right = helper(preorder,preorderStart+leftLen+1,preorderEnd,inorder,index+1,inorderEnd);

        return root;
    }
}
