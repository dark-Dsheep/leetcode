package Algorithm.Dp;

public class LC_2320 {

    /*
        2320. 统计放置房子的方式数
     */
    static int mod = (int) 1e9 + 7;
    Long[][] memo = new Long[10010][2];

    public int countHousePlacements(int n) {
        // dp做法
        // dp[i][0] -> 表示第i个地块不放置房子的方案数=第i-1处放置的方案数 + 第i-1出不放置房子的方案数
        // dp[i][1] -> 表示第i个地块放置房子的方案数=第i-1出不放置的方案数
        // var dp = new long[n + 1][2];
        // dp[1][0] = dp[1][1] = 1;
        // for (int i = 2; i <= n; i++) {
        //     dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
        //     dp[i][1] = dp[i - 1][1] % mod;
        // }
        // long cnt = (dp[n][0] + dp[n][1]) % mod;
        // return (int) (cnt * cnt % mod);
        long ans = dfs(n, 0, 0);
        return (int) (ans * ans % mod);
    }
    // 记忆化DFS
    // state -> 表示前一个地块的状态 0-不放置房子 1-放置房子
    long dfs(int n, int i, int state) {
        if (i == n) return 1;
        if (memo[i][state] != null) return memo[i][state];
        long ans = 0;
        if (state == 0) {   // 前一块没放置房子,那么当前可以选择放置房子也可以不放置房子
            ans = (ans + dfs(n, i + 1, 1) + dfs(n, i + 1, 0)) % mod;
        } else {            // 前一块地放置了房子,那么当前只能不防置房子
            ans = (ans + dfs(n, i + 1, 0)) % mod;
        }
        memo[i][state] = ans;
        return ans;
    }

    public static void main(String[] args) {

    }
}
