package day28;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-duplicate-subtrees/
 * @date 2022/5/6
 */
public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        helper(root,map,result);
        return result;
    }

    private String helper(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {
        if(root == null){
            return "#";
        }
        String left = helper(root.left,map,result);
        String right = helper(root.right,map,result);
        String val = root.val + "," + left + "," +right;
        Integer orDefault = map.getOrDefault(val, 0);
        if(orDefault == 1){
            result.add(root);
        }
        map.put(val,orDefault+1);
        return val;
    }
}
