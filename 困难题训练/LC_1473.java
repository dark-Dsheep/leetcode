package 困难题训练;

public class LC_1473 {

//    1473. 粉刷房子 III Rating(2056)

    Integer[][][] memo = new Integer[101][21][101];
    int[][] cs;
    int[] h;
    int m;
    int n;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.m = m;
        this.n = n;
        h = houses;
        cs = new int[m][n+1];
        // 预处理一下cost数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cs[i][j+1] = cost[i][j];
            }
        }
        int ans = dfs(0, 0, target);
        return ans == 0x3f3f3f ? -1 : ans;
    }

    /**
     *
     * @param i            第i个房子
     * @param pre     i-1房子的颜色
     * @param t            剩余街区数量
     * @return
     */
    int dfs(int i, int pre, int t) {
        if (i >= m) return t == 0 ? 0 : 0x3f3f3f;
        if (t < 0) return 0x3f3f3f;
        int ans = 0x3f3f3f;
        if (memo[i][pre][t] != null) return memo[i][pre][t];
        if (h[i] != 0) {
            if (h[i] == pre) {
                ans = Math.min(ans, dfs(i+1, h[i], t));
            } else {
                ans = Math.min(ans, dfs(i+1, h[i], t-1));
            }
        } else {
            for (int color = 1; color <= n; color++) {
                int v = cs[i][color];
                if (pre == color) {
                    // 融入上一个街区
                    ans = Math.min(ans, v + dfs(i+1, pre, t));
                } else {
                    // 划分新的街区
                    ans = Math.min(ans, v + dfs(i+1, color, t-1));
                }
            }
        }
        return memo[i][pre][t] = ans;
    }

    public static void main(String[] args) {
        int[] houses = {0, 2, 1, 2, 0};
        int[][] cost = {{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}};
        int m = 5;
        int n = 2;
        int target = 3;
        System.out.println(new LC_1473().minCost(houses, cost, m, n, target));
    }
}
