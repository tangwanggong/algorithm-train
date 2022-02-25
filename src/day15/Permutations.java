package day15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * @date 2022/2/25
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums,result,new LinkedList<>());
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result,LinkedList<Integer> path) {
        // 如果相等，就代表包含所有数据，不需要往下执行了
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            // 当前数字
            int num = nums[j];
            // 如果当前路径已经有当前数字了，跳过
            if(path.contains(num)){
                continue;
            }
            // 加到末尾
            path.addLast(num);
            // 回溯
            helper(nums,result,path);
            // 删掉末尾用的
            path.removeLast();
        }
    }
}
