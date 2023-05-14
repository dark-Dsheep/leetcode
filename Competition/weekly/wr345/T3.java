package Competition.weekly.wr345;

import java.util.Deque;
import java.util.LinkedList;

public class T3 {


    int[][] dirs = new int[][] {
            {-1, 1}, {1, 1}, {0, 1}
    };

    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] used = new boolean[m][n];
        Deque<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            q.offer(new int[] {i, 0, 0});
            used[i][0] = true;
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1], step = cur[2];
            ans = Math.max(ans, step);
            for (int i = 0; i < dirs.length; i++) {
                int ny = y + dirs[i][0];
                int nx = x + dirs[i][1];
                if (ny >= 0 && ny < m && nx >= 0 && nx < n) {
                    if (grid[ny][nx] <= grid[y][x]) continue;
                    if (!used[ny][nx]) {
                        used[ny][nx] = true;
                        q.offer(new int[] {ny, nx, step + 1});
                    }
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
