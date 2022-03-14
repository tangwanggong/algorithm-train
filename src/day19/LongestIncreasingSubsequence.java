package day19;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @date 2022/2/28
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // 每个代表当前与之前的最长严格递增子序列的长度
        int[] dp = new int[nums.length];
        // 初始化每个最小值为1，代表自身
        Arrays.fill(dp,1);
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 遍历之前的结果
            for (int j = 0; j < i; j++) {
                // 如果nums[i] > nums[j] 代表nums[i] 可以为nums[j] 最长严格递增子序列的长度 + 1
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int result = 0;
        for (int i : dp) {
            result = Math.max(result,i);
        }
        return result;
    }
}
