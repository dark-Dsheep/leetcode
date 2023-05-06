package Algorithm.DP;

import java.util.Arrays;

public class LC_279 {

//    279. 完全平方数

    public int numSquares(int n) {
        // 完全背包问题，每个数可以用多次
        // 求和为n的完全平方的最少数量 -> 装满背包最少需要的物品
        var dp = new int[n + 1];
        Arrays.fill(dp, 0x3f3f3f);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                // dp[i][j] = max(dp[i-1][j], dp[i][j-v] + w);
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
