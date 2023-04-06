package Algorithm.BackTrack;

public class LC_1219 {

//    1219. 黄金矿工

    int m, n = 0;

    public int getMaximumGold(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) return 0;
        if (grid[x][y] == 0)                    return 0;
        int temp = grid[x][y];
        int ans = grid[x][y];
        grid[x][y] = 0;
        int a = dfs(grid, x - 1, y);
        int b = dfs(grid, x + 1, y);
        int c = dfs(grid, x, y - 1);
        int d = dfs(grid, x, y + 1);
        ans += Math.max(Math.max(a, b), Math.max(c, d));
        // if (ans > 50) {
        //     System.out.println("ans -> " + ans);
        // }
        grid[x][y] = temp; // 恢复现场
        return ans;
    }
}
