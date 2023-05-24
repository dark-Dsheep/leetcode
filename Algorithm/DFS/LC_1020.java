package Algorithm.DFS;

public class LC_1020 {

    /*
        1020. 飞地的数量
     */

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 将边缘1进行DFS,看看能不能影响里面的1
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n-1);
        }
        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m-1, j);
        }
        int ans = 0;
        // 统计里面还剩多少个1
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row > grid.length-1 || col > grid[0].length-1) {
            return;
        }
        if (grid[row][col] == 0) return;
        grid[row][col] = 0;
        dfs(grid, row-1, col);
        dfs(grid, row, col+1);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
    }


    public static void main(String[] args) {

    }
}
