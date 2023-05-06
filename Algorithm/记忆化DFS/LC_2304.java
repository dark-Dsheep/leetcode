package Algorithm.记忆化DFS;

public class LC_2304 {


//    2304. 网格中的最小路径代价

    int m, n = 0;
    int[][] g, move;
    Integer[][] memo;

    public int minPathCost(int[][] grid, int[][] moveCost) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.g = grid;
        this.move = moveCost;
        this.memo = new Integer[m + 10][n + 10];

        int ans = 0x3f3f3f;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dfs(0, j));
        }
        return ans;
    }

    // 记忆化搜索
    int dfs(int x, int y) {
        if (x == m - 1) return g[x][y]; // 最后一行
        if (memo[x][y] != null) return memo[x][y];
        int cost = g[x][y];
        int ans = 0x3f3f3f;
        for (int j = 0; j < n; j++) {   // 搜索每一列
            ans = Math.min(ans, dfs(x + 1, j) + move[g[x][y]][j]);
        }
        ans += cost;
        memo[x][y] = ans;   // 记忆化
        // System.out.println("ans=" + ans);
        return ans;
    }


    public static void main(String[] args) {
        int[][] g = {{5, 3}, {4, 0}, {2, 1}};
        int[][] move = {{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}};
        System.out.println(new LC_2304().minPathCost(g, move));
    }
}
