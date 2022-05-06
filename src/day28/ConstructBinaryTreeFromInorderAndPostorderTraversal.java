package day28;

import structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @date 2022/5/6
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode helper(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
        if(postorderStart > postorderEnd){
            return null;
        }
        int rootValue = postorder[postorderEnd];
        TreeNode treeNode = new TreeNode(rootValue);

        int index = 0;
        for (int i = inorderStart; i <= inorderEnd ; i++) {
            if(rootValue == inorder[i]){
                index = i;
                break;
            }
        }

        int leftLen = index - inorderStart;

        treeNode.left = helper(inorder,inorderStart,index-1,postorder,postorderStart,postorderStart+leftLen-1);
        treeNode.right = helper(inorder,index+1,inorderEnd,postorder,postorderStart+leftLen,postorderEnd-1);

        return treeNode;
    }
}
