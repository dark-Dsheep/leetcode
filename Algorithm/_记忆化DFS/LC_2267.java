package Algorithm._记忆化DFS;

public class LC_2267 {

    /*
        2267. 检查是否有合法括号字符串路径
     */
    private int m, n = 0;
    private Boolean[][] memo;
    // private HashMap<String, Boolean> memo = new HashMap<>();

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        memo = new Boolean[m * n][m + n];
        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] g, int x, int y, int leftCnt) {
        if (x >= m || y >= n) return false;
        var key = x * n + y;    // 二维映射到一维
        if (memo[key][leftCnt] != null) {
            return memo[key][leftCnt];
        }
        var c = g[x][y];
        if (x == m - 1 && y == n - 1) {
            if (c == ')' && leftCnt == 1) return true;
            else                          return false;
        }
        var res = false;
        if (c == '(') {
            res |= dfs(g, x + 1, y, leftCnt + 1);
            res |= dfs(g, x, y + 1, leftCnt + 1);
        } else {
            if (leftCnt == 0) return false;
            res |= dfs(g, x + 1, y, leftCnt - 1);
            res |= dfs(g, x, y + 1, leftCnt - 1);
        }
        memo[key][leftCnt] = res; // 记忆化
        return res;
    }

    public static void main(String[] args) {

        char[][] g = {{'(',')',')','(',')',')',')'}};
        System.out.println(new LC_2267().hasValidPath(g));
    }
}
