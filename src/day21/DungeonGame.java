package day21;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/dungeon-game/
 * @date 2022/3/2
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length , n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints,Integer.MAX_VALUE);
        }
        // base 到达这些位置血量最低为1，也就是P点的下个位置
        dp[m][n-1] = dp[m-1][n] = 1;
        for (int i = m - 1; i >= 0 ; i--) {
            for (int j = n-1; j >= 0; j--) {
                // 从P点开始，取到达下个位置最小需要血量 - dungeon[i][j]（也就是当前格的血量），如果大于0，则说明前面最低需要1滴血走到这里，小于0则需要Math.min(dp[i+1][j],dp[i][j+1]) - dungeon[i][j]滴血
                dp[i][j] = Math.max(Math.min(dp[i+1][j],dp[i][j+1]) - dungeon[i][j],1);
            }
        }
        return dp[0][0];
    }
}
