package Algorithm.Dp;

public class LC_312 {


//    312. 戳气球

    int[][] dp = new int[305][305];
    int[] g = new int[305];
    // 第II类区间DP
    public int maxCoins(int[] nums) {
        int n = nums.length;
        System.arraycopy(nums, 0, g, 1, n);
        g[0] = g[n + 1] = 1; // 预处理边界值
        for (int len = 1; len <= n; len++) {            // 区间大小
            for (int i = 1; i + len - 1 <= n; i++) {    // 起始位置
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {           // 枚举最后一戳 k
                    dp[i][j] = Math.max(
                            dp[i][j],
                            dp[i][k - 1] + g[i - 1] * g[k] *g[j + 1] + dp[k + 1][j]
                    );
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {

    }
}
