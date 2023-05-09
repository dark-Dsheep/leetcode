package 困难题训练;

public class LC_1411 {


//    1411. 给 N x 3 网格图涂色的方案数 Rating(1845)

    int mod = 1000000007;
    long[][] memo = new long[5001][2];
    int N;

    public int numOfWays(int n) {
        // 涂色分为2种方案 ABA ABC
        // 当前层涂色为ABA，那么下层可以涂色的情况为5种，3个ABA 2个ABC
        // 当前层涂色为ABC，那么下层可以涂色的情况为4种，2个ABA 2个ABC
        // 当前ABA类型 010 下一层如果是ABA类型 101 020 202
        //                下一层如果是ABC类型 201 102
        // 当前ABC类型 012 下一层如果是ABA类型 101 121
        //                下一层如果是ABC类型 210 120
//        long[][] dp = new long[n+1][2];
//        dp[1][0] = 6;
//        dp[1][1] = 6;
//        for (int i = 2; i <= n; i++) {
//            dp[i][0] = (3 * dp[i-1][0] + 2 * dp[i-1][1]) % mod;
//            dp[i][1] = (2 * dp[i-1][0] + 2 * dp[i-1][1]) % mod;
//        }
//        return (int) ((dp[n][0] + dp[n][1]) % mod);
        N = n;
        return (int) dfs(0, 0);
    }

    long dfs(int i, int c) {
        if (i >= N) return 1;
        if (i == 0) return 6 * (dfs(i+1, 0) + dfs(i+1, 1)) % mod;
        if (memo[i][c] != 0) return memo[i][c];
        long ans = 0;
        if (c == 1) {
            ans = (ans + 2 * dfs(i+1, 0) + 2 * dfs(i+1, 1)) % mod;
        } else {
            ans = (ans + 3 * dfs(i+1, 0) + 2 * dfs(i+1, 1)) % mod;
        }
        return memo[i][c] = ans;
    }

    public static void main(String[] args) {
        System.out.println(new LC_1411().numOfWays(1));
    }
}
