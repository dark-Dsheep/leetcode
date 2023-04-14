package Algorithm._记忆化DFS;

public class LC_576 {


    /*
        576. 出界的路径数
     */
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int mod = (int) 1e9 + 7;
    private Integer[][][] memo;
    private int m, n = 0;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        memo = new Integer[m][n][maxMove + 1];
        return dfs(startRow, startColumn, maxMove);
    }
    // x y maxMove都是变量, 需要一个三维空间存储中间结果
    private int dfs(int x, int y, int maxMove) {
        // 无论maxMove是否用光 球已经出界 路径+1
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 1;
        }
        // maxMove用光还没有出界 路径+0
        if (maxMove == 0) return 0;
        if (memo[x][y][maxMove] != null) return memo[x][y][maxMove];
        int res = 0;
        for (var dir : dirs) {
            res += dfs(x + dir[0], y + dir[1], maxMove - 1);
            res %= mod;
        }
        memo[x][y][maxMove] = res; // 记忆化
        return res;
    }

    public static void main(String[] args) {

    }
}
