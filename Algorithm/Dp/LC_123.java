package Algorithm.Dp;

public class LC_123 {

//    123. 买卖股票的最佳时机 III
    public int maxProfit(int[] prices) {
        // 第i-1轮  持有第1股   售出第1股  持有第2股   售出第2股
        // 第i轮    持有第1股   售出第1股  持有第2股   售出第2股
        int n = prices.length;
        var dp = new int[n][4];
        dp[0][0] = -prices[0]; // 第0天持有第一股
        dp[0][2] = -prices[0]; // 第0天持有第二股
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][3]);
    }

    public static void main(String[] args) {

    }
}
