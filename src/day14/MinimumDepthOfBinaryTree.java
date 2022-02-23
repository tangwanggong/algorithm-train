package day14;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * @date 2022/2/23
 */
public class MinimumDepthOfBinaryTree {
    // BFS
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        // 初始化深度,因为root也算一层，所以是1
        int depth = 1;
        // 当前层需要遍历的节点都在queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            // 遍历当前层的每一个
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                // 如果左右子节点都是null，就返回深度
                if (poll.left == null && poll.right == null){
                    return depth;
                }
                // 左子节点不是，下一层加上左子节点
                if(poll.left != null){
                    queue.add(poll.left);
                }
                // 同上
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }
            // 遍历完一层+1
            depth++;
        }
        return depth;
    }
}
