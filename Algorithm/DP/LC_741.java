package Algorithm.DP;

public class LC_741 {


    /*
        741. 摘樱桃
     */
    private int m, n = 0;
    //TODO
    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        // 第一次dfs
        int a = dfs1(grid, 0, 0);
        // 第二次dfs
        int b = dfs2(grid, m - 1, n - 1);
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        return a + b;
    }
    // start -> end
    private int dfs1(int[][] grid, int x, int y) {
        if (x >= m || y >= n || grid[x][y] == -1) return 0;
        var res = 0;
        if (grid[x][y] == 1) {
            res++;
            grid[x][y] = 0;
        }
        if (x == m - 1 && y == n - 1) return res;
        res += Math.max(dfs1(grid, x + 1, y), dfs1(grid, x, y + 1));
        return res;
    }
    // end -> start
    private int dfs2(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || grid[x][y] == -1) return 0;
        var res = 0;
        if (grid[x][y] == 1) {
            res++;
            grid[x][y] = 0;
        }
        if (x == 0 && y == 0) return res;
        res += Math.max(dfs2(grid, x - 1, y), dfs2(grid, x, y - 1));
        return res;
    }

    public static void main(String[] args) {
        var grid = new int[][]{
                {0, 1, -1},
                {1, 0, -1},
                {1, 1, 1}
        };
        System.out.println(new LC_741().cherryPickup(grid));
    }
}
