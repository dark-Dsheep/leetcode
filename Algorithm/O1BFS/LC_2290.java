package Algorithm.O1BFS;

import java.util.Arrays;
import java.util.LinkedList;

public class LC_2290 {


//    2290. 到达角落需要移除障碍物的最小数目
    // 01BFS
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m+1][n+1];
        for (var d : dist) Arrays.fill(d, 0x3f3f3f);
        var q = new LinkedList<int[]>();
        q.offer(new int[]{0, 0});
        dist[0][0] = 0;
        while (q.size() > 0) {
            var p = q.poll();
            int x = p[0], y = p[1];
            for (var d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                int f = grid[nx][ny] == 0 ? 0 : 1; // 判断是否需要移除
                int nxc = dist[x][y] + f;
                if (dist[nx][ny] > nxc) {
                    dirs[nx][ny] = nxc;
                    // O1BFS
                    if (f == 0) q.addFirst(new int[]{nx, ny});
                    else q.addLast(new int[]{nx, ny});
                }
            }
        }
        return dist[m-1][n-1];
    }

    public static void main(String[] args) {

    }
}
