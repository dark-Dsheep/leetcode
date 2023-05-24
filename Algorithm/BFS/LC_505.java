package Algorithm.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC_505 {

    int m, n;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] dist = new int[110][110]; // 记录节点间的距离

    /*
        505. 迷宫 II
     */
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        m = maze.length;
        n = maze[0].length;
        // 球门周围必需有墙，球才能停住
        for (int[] d : dist) Arrays.fill(d, 0x3f3f3f);
        dist[start[0]][start[1]] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0], y = p[1];
            for (int[] d: dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                int nextStep = 0;
                // 向一个方向一直走
                while (nx >= 0 && ny >= 0 && nx < m && ny < n && maze[nx][ny] == 0) {
                    nx += d[0];
                    ny += d[1];
                    nextStep += 1;
                }
                nx = nx - d[0];
                ny = ny - d[1];
                if (dist[x][y] + nextStep < dist[nx][ny]) {
                    dist[nx][ny] = dist[x][y] + nextStep; // 更新最短距离
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return dist[dest[0]][dest[1]] == 0x3f3f3f ? -1 : dist[dest[0]][dest[1]];
    }


    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
        int[] dest = {4, 4};
        System.out.println(new LC_505().shortestDistance(maze, start, dest));
    }
}
