package Algorithm.Bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC_490 {

    int m, n;
    boolean[][] vis = new boolean[110][110];
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /*
        490. 迷宫
     */
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        m = maze.length;
        n = maze[0].length;
        // 球门周围必需有墙，球才能停住
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});
        while (!queue.isEmpty()) {
            int[] p = queue.remove();
            int x = p[0], y = p[1];
            if (x == dest[0] && y == dest[1]) return true;
            for (int[] d: dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                // 向一个方向一直走
                while (nx >= 0 && ny >= 0 && nx < maze.length && ny < maze[0].length && maze[nx][ny] == 0) {
                    nx += d[0];
                    ny += d[1];
                }
                nx = nx - d[0];
                ny = ny - d[1];
                if (!vis[nx][ny]) {
                    queue.add(new int[] {nx, ny});
                    vis[nx][ny] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
