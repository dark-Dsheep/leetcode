package Algorithm.DP;


public class LC_2312 {


//    2312. 卖木头块

    Long[][] memo = new Long[210][210];
    int[][] v = new int[210][210];

    public long sellingWood(int m, int n, int[][] prices) {
        // 一块高m 宽n的木块有三种方式卖出
        // v[m][n] 表示将高m 宽n的木块卖出的价值
        // 1.将它整块卖出 -> 收益=v[m][n]
        // 2.将它垂直切割成两块卖出 -> 收益=v[k][n] + v[m-k][n] k的取值范围[1,m)
        // 2.将它水平切割成两块卖出 -> 收益=v[m][k] + v[m][n-k] k的取值范围[1,n)
        for (var p : prices) {
            v[p[0]][p[1]] = p[2];
        }
        // dp做法
        // var dp = new long[m+1][n+1]; // dp[i][j] 表示一块高i 宽j的木块卖出的最大收益
        // for (int i = 1; i <= m; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         dp[i][j] = v[i][j];
        //         // 根据对称性 k只需枚举到 垂直方向中间 或者水平方向中间
        //         for (int k = 1; k <= i / 2; k++) {
        //             dp[i][j] = Math.max(dp[i][j], dp[k][j] + dp[i-k][j]);
        //         }
        //         for (int k = 1; k <= j / 2; k++) {
        //             dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[i][j-k]);
        //         }
        //     }
        // }
        // return dp[m][n];
        long ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        return ans;
    }

    // 记忆化DFS
    long dfs(int m, int n) {
        if (memo[m][n] != null) return memo[m][n];
        long ans = v[m][n];
        // 根据对称性 k只需枚举到 垂直方向中间 或者水平方向中间
        for (int k = 1; k <= m / 2; k++) {
            ans = Math.max(ans, dfs(k, n) + dfs(m-k, n));
        }
        for (int k = 1; k <= n / 2; k++) {
            ans = Math.max(ans, dfs(m, k) + dfs(m, n-k));
        }
        memo[m][n] = ans;
        return ans;
    }


    public static void main(String[] args) {
        int m = 3;
        int n = 5;
        int[][] prices = {{1, 4, 2}, {2, 2, 7}, {2, 1, 3}};
        System.out.println(new LC_2312().sellingWood(m, n, prices));
    }
}
