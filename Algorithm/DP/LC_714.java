package Algorithm.DP;

public class LC_714 {

//    714. 买卖股票的最佳时机含手续费

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // dp[i][0]表示第i天持有股票
        // dp[i][1]表示第i天不持有股票
        var dp = new int[n][2];
        dp[0][0] -= prices[0];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            // max(上一天持有股票, 上一天不持有股票在今天买入)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            // max(上一天不持有股票, 上一天持有股票在今天卖出)
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
            ans = Math.max(dp[i][0], dp[i][1]);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
