package Algorithm.DP;

import java.util.Arrays;

public class LC_1824 {

//    1824. 最少侧跳次数
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[][] dp = new int[n + 1][3];
        for (int i = 0; i <= n; i++) Arrays.fill(dp[i], 0x3f3f3f);
        dp[0][1] = 0;
        dp[0][0] = dp[0][2] = 1;
        int ans = 0x3f3f3f;
        for (int i = 1; i < n; i++) {
            int v = obstacles[i];
            if (v == 1) {
                // 第i - 1处的0跑道不能直接跳到第i处0跑道
                // 第i处的1跑道只能 由第i-1的1跑道跳 或者i-1的2跑道侧跳过来
                dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][2] + 1);
                dp[i][2] = Math.min(dp[i - 1][2], dp[i - 1][1] + 1);
            } else if (v == 2) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][2] + 1);
                dp[i][2] = Math.min(dp[i - 1][2], dp[i - 1][0] + 1);
            } else if (v == 3) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1] + 1);
                dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0] + 1);
            } else {
                // 第i处没有障碍
                dp[i][0] = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2]) + 1);
                dp[i][1] = Math.min(dp[i - 1][1], Math.min(dp[i - 1][0], dp[i - 1][2]) + 1);
                dp[i][2] = Math.min(dp[i - 1][2], Math.min(dp[i - 1][0], dp[i - 1][1]) + 1);
            }
            ans = Math.min(dp[i][0], Math.min(dp[i][1], dp[i][2]));
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
