package Algorithm.DP;

public class LC_309 {

//    309. 最佳买卖股票时机含冷冻期
    public int maxProfit(int[] p) {
        int n = p.length;
        // dp[i][0] -> 卖出(不持有股票)
        // dp[i][1] -> 买入(持有股票)
        // dp[i][2] -> 冷冻期 不能买入,显然最大收益是i-1天卖出状态
        var dp = new int[n][3];
        dp[0][0] = dp[0][2] = 0;
        dp[0][1] = -p[0];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            // 第i天卖出 = max(i-1天卖出状态, i-1天买入的在今天卖出, i-1天处于冷冻期)
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1] + p[i]), dp[i - 1][2]);
            // 第i天买入 = max(i-1天买入状态, i-1天处理冷冻期并且在今天买入)
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - p[i]);
            dp[i][2] = dp[i - 1][0];
            ans = Math.max(Math.max(dp[i][0], dp[i][1]), dp[i][2]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 4};
        System.out.println(new LC_309().maxProfit(prices));
    }
}
