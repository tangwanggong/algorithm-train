package day20;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 * @date 2022/3/1
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m * n == 0){
            return m+n;
        }
        int[][] dp = new int[m+1][n+1];
        // base 从 word1的第i位到word2为空，需要执行i步
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        // 同上
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果两个字母相同，不需要转换
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    // dp[i-1][j] + 1 删除 word1中一个 ，dp[i][j-1]+1增加word1 1个字母, dp[i-1][j-1]+1 替换一个字母
                    dp[i][j] = Math.min(dp[i-1][j] + 1 ,Math.min(dp[i][j-1]+1,dp[i-1][j-1]+1));
                }
            }
        }
        return dp[m][n];
    }
}
