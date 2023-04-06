package Algorithm.Bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC_1730 {

    int m, n;
    boolean[][] vis = new boolean[210][210];
    int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /*
        1730. 获取食物的最短路径
     */
    public int getFood(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    return bfs(grid, i, j);
                }
            }
        }
        return -1;
    }

    private int bfs(char[][] grid, int row, int col) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(row, col, 0));
        while (!queue.isEmpty()) {
            Node p = queue.poll();
            int x = p.x, y = p.y;
            if (grid[x][y] == '#') {
                return p.step;
            }
            vis[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 'X') {
                    continue;
                }
                if (!vis[nx][ny]) {
                    vis[nx][ny] = true;
                    queue.offer(new Node(nx, ny, p.step + 1));
                }
            }
        }
        return -1;
    }

    class Node {
        int x, y;
        int step;

        public Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    public static void main(String[] args) {

    }
}
