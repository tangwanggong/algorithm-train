package day16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 * @date 2022/2/25
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums,0,result,new LinkedList<>());
        return result;
    }

    private void helper(int[] nums, int start, List<List<Integer>> result, LinkedList<Integer> path) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            // start = i+1 当前的索引+1, i 前面的都已经被使用过了
            helper(nums,i+1,result,path);
            path.removeLast();
        }
    }
}
