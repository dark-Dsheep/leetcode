package Algorithm.BFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LC_1368 {

    /*
        1368. 使网格图至少有一条有效路径的最小代价
     */

    int[][] dist;
    int m, n = 0;
    int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dist = new int[m + 10][n + 10];
        for (int[] d : dist) Arrays.fill(d, 0x3f3f3f);
        dist[0][0] = 0;
        Deque<int[]> queue = new ArrayDeque<>();
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
                int k = i + 1 == grid[x][y] ? 0 : 1;
                // nc为起点经过grid[x][y]到达grid[nx][ny]的最小代价
                int nextCost = dist[x][y] + k;
                // 小于原来的cost[nx][ny]就可以更新并入队
                if (dist[nx][ny] > nextCost) {
                    dist[nx][ny] = nextCost;
                    // 重点
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
        int[][] grid = {{2, 2, 2}, {2, 2, 2}};
        System.out.println(new LC_1368().minCost(grid));
    }
}
