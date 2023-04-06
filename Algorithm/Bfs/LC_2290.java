package Algorithm.Bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LC_2290 {

    /*
        2290. 到达角落需要移除障碍物的最小数目
     */

    int[][] dist; // 计算到每个点的最短距离
    int m, n = 0;
    int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minimumObstacles(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dist = new int[m + 10][n + 10];
        for (int[] d : dist) Arrays.fill(d, 0x3f3f3f);
        Deque<int[]> queue = new ArrayDeque<>();
        dist[0][0] = 0;
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.pollFirst();
            int x = p[0], y = p[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                // 判断需不需要移除障碍物
                int k = grid[nx][ny] == 0 ? 0 : 1;
                int nextCost = dist[x][y] + k;
                if (dist[nx][ny] > nextCost) { // 更新最小代价
                    dist[nx][ny] = nextCost;
                    // O1-BFS
                    if (k == 0) {
                        queue.addFirst(new int[]{nx, ny});
                    } else {
                        queue.addLast(new int[]{nx, ny});
                    }
                }
            }
        }
        return dist[m - 1][n - 1];
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0}
        };
        System.out.println(new LC_2290().minimumObstacles(grid));
    }
}
