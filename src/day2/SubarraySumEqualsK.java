package day2;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/submissions/
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        // 初始化
        map.put(0,1);
        // sum0_i ,nums[0]到nums[i]的和
        int sum0_i = 0,result = 0;
        for (int i = 0; i < nums.length; i++) {
            // 加当前nums[i]
            sum0_i += nums[i];
            // 需要sum[0]到sum[j]的值
            int sum0_j = sum0_i - k;
            // 如果存在就加上
            if(map.containsKey(sum0_j)){
                result += map.get(sum0_j);
            }
            // 存nums[0]到nums[i]的和 的次数
            map.put(sum0_i, map.getOrDefault(sum0_i,0)+1);
        }
        return result;
    }

}
