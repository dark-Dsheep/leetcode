package Algorithm.Bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC_695 {


    /*
        695. 岛屿的最大面积
     */


    int m, n;
    int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    res = Math.max(res, bfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int bfs(int[][] grid, int r, int c) {
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + d[i][0];
                int ny = p[1] + d[i][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0) {
                    continue;
                }
                cnt += 1;
                grid[nx][ny] = 0;
                queue.offer(new int[]{nx, ny});
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
