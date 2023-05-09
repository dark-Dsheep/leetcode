package 困难题训练;

import java.util.Arrays;
import java.util.LinkedList;

public class LC_1293 {

//    1293. 网格中的最短路径 Rating(1967)

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] vis = new int[41][41];

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(vis[i], -1);
        }
        vis[0][0] = k;
        var q = new LinkedList<int[]>();
        q.offer(new int[]{0, 0, 0});
        while (q.size() > 0) {
            var p = q.poll();
            int x = p[0], y = p[1];
            if (x == m - 1 && y == n - 1) return ans;
            int cnt = p[2]; // 消除次数
            for (var d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                int ncnt = grid[nx][ny] == 1 ? cnt + 1 : cnt;
                // 剪枝
                if (ncnt > vis[nx][ny]) {
                    vis[x][y] = ncnt;
                    q.offer(new int[]{x, y, ncnt});
                }
            }
        }
        return -1;
    }



    public static void main(String[] args) {

    }
}
