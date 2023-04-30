package Competition.biweekly.bw103;

import java.util.LinkedList;

public class T3 {

    int m;
    int n;
    int[][] grid;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int findMaxFish(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                ans = Math.max(ans, bfs(i, j));
            }
        }
        return ans;
    }

    private int bfs(int i, int j) {
        var vis = new boolean[m+1][n+1];
        int ans = grid[i][j];
        var q = new LinkedList<int[]>();
        q.offer(new int[]{i, j});
        vis[i][j] = true;
        while (q.size() > 0) {
            int[] p = q.poll();
            int x = p[0], y = p[1];
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0) {
                    continue;
                }
                if (!vis[nx][ny]) {
                    vis[nx][ny] = true;
                    ans += grid[nx][ny];
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return ans;
    }
}
