package Algorithm._记忆化DFS;

public class LC_2328 {

    /*
        2328. 网格图中递增路径的数目
     */
    private int[][] memo = new int[1010][1010];
    private int m, n = 0;
    private int mod = (int) 1e9 + 7;

    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        var res = 0;
        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                int cnt =
                        res = (res + dfs(i, j, Integer.MIN_VALUE, grid)) % mod;
            }
        }
        return res;
    }

    private int dfs(int x, int y, int preVal, int[][] grid) {
        if (x < 0 || x >= m || y < 0 || y >= n) return 0;
        if (grid[x][y] <= preVal) return 0; // 非递增路径
        if (memo[x][y] != 0) return memo[x][y];
        var res = 1;            // 初始化递增路径都为1
        // 计算以当前x,y 为起点的递增路径数量
        res = (res + dfs(x - 1, y, grid[x][y], grid) +
                dfs(x + 1, y, grid[x][y], grid) +
                dfs(x, y - 1, grid[x][y], grid) +
                dfs(x, y + 1, grid[x][y], grid)) % mod;
        memo[x][y] = res;
        return res;
    }

    public static void main(String[] args) {

        var grid = new int[][] {
                {1, 1}, {3, 4}
        };
        System.out.println(new LC_2328().countPaths(grid));
    }
}
