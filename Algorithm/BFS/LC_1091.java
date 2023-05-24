package Algorithm.BFS;

import java.util.LinkedList;

public class LC_1091 {

//    1091. 二进制矩阵中的最短路径

    int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int m = grid.length, n = grid[0].length;
        var q = new LinkedList<int[]>();
        q.offer(new int[]{0, 0, 1});
        grid[0][0] = 1;
        while (q.size() > 0) {
            var p = q.poll();
            int x = p[0], y = p[1], step = p[2];
            if (x == m - 1 && y == n - 1) return step;
            for (var d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 1) continue;
                q.offer(new int[]{nx, ny, step + 1});
                grid[nx][ny] = 1; // 将0设置为1防止重复访问
            }
        }
        return -1;
    }


    public static void main(String[] args) {

    }
}
