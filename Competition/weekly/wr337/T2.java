package Competition.weekly.wr337;

import java.util.LinkedList;
import java.util.Queue;

public class T2 {

    boolean[][] vis = new boolean[10][10];
    int[][] dirs = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
    public boolean checkValidGrid(int[][] grid) {
        int m = grid.length;
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,0});
        vis[0][0] = true;
        while (q.size() > 0) {
            int[] p = q.poll();
            int x = p[0], y = p[1], time = p[2];
            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (!vis[nx][ny]) {
                    if (grid[nx][ny] == time+ 1) {
                        vis[nx][ny] = true;
                        q.offer(new int[]{nx, ny, time + 1});
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
