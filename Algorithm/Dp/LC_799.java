package Algorithm.Dp;

public class LC_799 {

    /*
        799. 香槟塔
     */
    public double champagneTower(int k, int n, int m) {
        // 状态定义: dp[i][j] 为第 i 行第 j 列杯子所经过的水的流量
        var dp = new double[n + 10][n + 10];
        dp[0][0] = k;
        for (var i = 0; i <= n; i++) {
            for (var j = 0; j <= i; j++) {
                // 上一个杯子的水流量不会超过1
                if (dp[i][j] <= 1) continue;
                // 超过1则平均分摊到dp[i+1][j],dp[i+1][j+1]杯子
                dp[i + 1][j] += (dp[i][j] - 1) / 2;
                dp[i + 1][j + 1] += (dp[i][j] - 1) / 2;
            }
        }
        return Math.min(dp[n][m], 1);
    }

    public static void main(String[] args) {

    }
}
