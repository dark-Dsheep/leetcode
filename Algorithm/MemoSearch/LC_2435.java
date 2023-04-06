package Algorithm.MemoSearch;

public class LC_2435 {

    /*
        2435. 矩阵中和能被 K 整除的路径
     */
    private int mod = (int) 1e9 + 7;
    private int m, n = 0;
    private Integer[][][] memo;

    public int numberOfPaths(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        memo = new Integer[m + 1][n + 1][k];

        return dfs(grid, 0, 0, 0, k);
    }

    private int dfs(int[][] grid, int x, int y, int sum, int k) {
        if (x >= m || y >= n) return 0;
        // 重点: 把路径和模 k 的结果当成一个扩展维度
        sum = (sum + grid[x][y]) % k;
        if (x == m - 1 && y == n - 1) {
            if (sum % k == 0)        return 1;
            else                     return 0;
        }
        if (memo[x][y][sum] != null) {
            return memo[x][y][sum];
        }
        int res = 0;
        res = (res + dfs(grid, x + 1, y, sum, k)) % mod;
        res = (res + dfs(grid, x, y + 1, sum, k)) % mod;

        memo[x][y][sum] = res;  // 记忆化
        return res;
    }

    public static void main(String[] args) {

    }
}
