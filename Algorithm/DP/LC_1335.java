package Algorithm.DP;

public class LC_1335 {

    int[] g;
    // 第I类区间DP
    public int minDifficulty(int[] job, int d) {
        if (job.length < d) return -1; // 无法将所有任务分成d天
        int n = job.length;
        g = new int[n + 1];
        for (int i = 1; i <= n; i++) g[i] = job[i - 1];
        var dp = new int[n + 1][d + 1];
        // 初始化d=1的时候 dp[i][k]的值
        for (int i = 1; i <= n; i++) dp[i][1] = getMax(1, i);
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int k = 2; k <= Math.min(i, d); k++) {
                dp[i][k] = 0x3f3f3f;
                for (int j = i; j >= k; j--) {
                    dp[i][k] = Math.min(dp[i][k], dp[j - 1][k - 1] + getMax(j, i));
                }
            }
        }
        return dp[n][d];
    }
    // 获取当前区间的最大难度
    int getMax(int j, int i) {
        int ans = 0;
        for ( ; j <= i; j++) {
            ans = Math.max(ans, g[j]);
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
