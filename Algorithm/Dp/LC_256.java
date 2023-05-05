package Algorithm.Dp;

public class LC_256 {

    /**
     * 256. 粉刷房子
     */

    public int minCost(int[][] costs) {
        int n = costs.length;
        // var f = new int[n+1][3];
        // f[0][0] = costs[0][0];
        // f[0][1] = costs[0][1];
        // f[0][2] = costs[0][2];
        // for (int i = 1; i < n; i++) {
        //     f[i][0] = Math.min(f[i-1][1], f[i-1][2]) + costs[i][0];
        //     f[i][1] = Math.min(f[i-1][0], f[i-1][2]) + costs[i][1];
        //     f[i][2] = Math.min(f[i-1][0], f[i-1][1]) + costs[i][2];
        // }
        // return Math.min(f[n-1][0], Math.min(f[n-1][1], f[n-1][2]));
        // for (int i = 0; i < n; i++) {
        //     f[i+1][0] = Math.min(f[i][1], f[i][2]) + costs[i][0];
        //     f[i+1][1] = Math.min(f[i][0], f[i][2]) + costs[i][1];
        //     f[i+1][2] = Math.min(f[i][0], f[i][1]) + costs[i][2];
        // }
        // return Math.min(f[n][0], Math.min(f[n][1], f[n][2]));

        // 滚动变量优化一下
        int a = costs[0][0], b = costs[0][1], c = costs[0][2];
        int nextA, nextB, nextC;
        for (int i = 1; i < n; i++) {
            nextA = Math.min(b, c) + costs[i][0];
            nextB = Math.min(a, c) + costs[i][1];
            nextC = Math.min(a, b) + costs[i][2];
            a = nextA;
            b = nextB;
            c = nextC;
        }
        return Math.min(a, Math.min(b, c));
    }
}
