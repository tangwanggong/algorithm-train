package day18;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * @date 2022/2/28
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // 自底向上
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        // base
        dp[0] = 0;
        // i 代表当前需要组成多少钱
        for (int i = 1; i <= amount; i++) {
            // 遍历当前金额
            for (int coin : coins) {
                // 如果i<当前金额,则跳过
                if(i-coin <0){
                    continue;
                }
                // 取最小值
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount] == amount+1 ? -1:dp[amount];
    }
}
