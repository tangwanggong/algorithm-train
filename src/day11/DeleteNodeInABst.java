package day11;

import structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 */
public class DeleteNodeInABst {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val == key){
            // 如果左右子节点都为null（返回null），或者一方为null，一方不为null（返回双方）
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            // 寻找到右侧最小的子节点
            TreeNode min = getMin(root.right);
            // 删除掉
            root.right = deleteNode(root.right,min.val);
            // 最小子节点就代替了root节点，完成删除
            min.left = root.left;
            min.right = root.right;
            root = min;
        }else if(root.val<key){
            // 小于说明需要在右侧找
            root.right = deleteNode(root.right,key);
        }else if (root.val>key){
            // 同上
            root.left = deleteNode(root.left,key);
        }
        return root;
    }

    // 搜索二叉树寻找最小的就是在最左边的子节点
    private TreeNode getMin(TreeNode treeNode){
        while (treeNode.left != null){
            treeNode = treeNode.left;
        }
        return treeNode;
    }
}
