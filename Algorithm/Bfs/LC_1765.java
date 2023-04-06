package Algorithm.Bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC_1765 {


    /*
        1765. 地图中的最高点
     */

    boolean[][] vis = new boolean[1010][1010];
    int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n = 0;

    public int[][] highestPeak(int[][] isWater) {
        m = isWater.length;
        n = isWater[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    vis[i][j] = true;
                    isWater[i][j] = 0;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0], y = p[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny]) continue;
                vis[nx][ny] = true;
                isWater[nx][ny] = isWater[x][y] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }
        return isWater;
    }

    public static void main(String[] args) {
        int[][] isWater = {{0, 1}, {0, 0}};
        System.out.println(Arrays.deepToString(new LC_1765().highestPeak(isWater)));
    }
}
