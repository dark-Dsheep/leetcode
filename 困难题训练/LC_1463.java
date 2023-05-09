package 困难题训练;

public class LC_1463 {

//    1463. 摘樱桃 II Rating(1957)
    Integer[][][] f = new Integer[71][71][71];
    int[][] g;
    int m = 0, n = 0;

    public int cherryPickup(int[][] grid) {
        g = grid;
        m = g.length;
        n = g[0].length;
        return dfs(0, 0, n-1);
    }

    /**
     *
     * @param x     层数
     * @param y1    机器人1所在的列
     * @param y2    机器人2所在的列
     * @return
     */
    int dfs(int x, int y1, int y2) {
        if (x == m) return 0;
        if (f[x][y1][y2] != null) return f[x][y1][y2];
        int ans = 0;
        int v = y1 == y2 ? g[x][y1] : g[x][y1] + g[x][y2];
        for (int i = y1-1; i <= y1+1; i++) {
            for (int j = y2-1; j <= y2+1; j++) {
                if (i < 0 || i >= n || j < 0 || j >= n) continue;
                ans = Math.max(ans, v + dfs(x+1, i, j));
            }
        }
        return f[x][y1][y2] = ans;
    }

    public static void main(String[] args) {

    }
}
