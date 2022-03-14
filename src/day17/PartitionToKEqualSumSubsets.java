package day17;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/
 */
public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k>nums.length){
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 说明不能被整除
        if(sum % k != 0){
            return false;
        }
        // 每个桶的值
        int target = sum/k;
        Map<Integer,Boolean> cache = new HashMap<>();
        return helper(nums,0,k,0,0,target,cache);
    }

    // 用used记录数组使用情况，第i位0代表未使用，1代表已使用
    private boolean helper(int[] nums,int bucket, int k, int start, int used, int target, Map<Integer,Boolean> cache) {
        // k==0说明无桶，并分配完全
        if(k == 0){
            return true;
        }
        // 如果当前桶和为目标值，填下个桶
        if(bucket == target){
            boolean res = helper(nums, 0, k - 1, 0, used, target, cache);
            // 记录结果
            cache.put(used,res);
            return res;
        }
        // 存在当前used即返回
        if(cache.containsKey(used)){
            return cache.get(used);
        }
        for (int i = start; i < nums.length; i++) {
            // 判断第i位是否用过
            if(((used >> i) & 1) == 1){
                continue;
            }
            // 判断是否大于目标值
            if(bucket + nums[i] > target){
                continue;
            }
            // 设置第i位为1
            used |= 1 << i;
            // 桶和相加
            bucket += nums[i];
            if(helper(nums,bucket,k,i+1,used,target,cache)){
                return true;
            }
            bucket -= nums[i];
            // 第i位用完就设置为0
            used ^= 1 << i;
        }
        // 没合适的就返回false
        return false;
    }
}
