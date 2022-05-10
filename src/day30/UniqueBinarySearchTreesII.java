package day30;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/unique-binary-search-trees-ii/
 * @date 2022/5/10
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return build(1,n);
    }

    private List<TreeNode> build(int lo, int hi) {
        List<TreeNode> result = new ArrayList<>();
        if(lo > hi){
            result.add(null);
            return result;
        }
        for (int i = lo; i < hi; i++) {
            List<TreeNode> left = build(lo,i-1);
            List<TreeNode> right = build(i+1,hi);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    result.add(node);
                }
            }
        }
        return result;
    }
}
