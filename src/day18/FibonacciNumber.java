package day18;

/**
 * https://leetcode-cn.com/problems/fibonacci-number/
 * @date 2022/2/28
 */
public class FibonacciNumber {
    public int fib(int n) {
        if(n < 2){
            return n;
        }
        // 自底向上
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
