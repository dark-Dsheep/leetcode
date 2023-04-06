package Algorithm.Bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC_286 {

    /*
        286. 墙与门
     */
    int m, n;
    int INF = 2147483647;
    boolean[][] vis = new boolean[260][260];
    int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void wallsAndGates(int[][] rooms) {
        m = rooms.length;
        n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == INF) { // BFS空房间
                    for (boolean[] v : vis) Arrays.fill(v, false);
                    bfs(i, j, rooms);
                }
            }
        }
        for (int[] arr : rooms) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private void bfs(int row, int col, int[][] rooms) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(row, col, 0));
        while (!queue.isEmpty()) {
            Node p = queue.poll();
            int x = p.x, y = p.y;
            if (rooms[x][y] == 0) { // 到达最近门
                rooms[row][col] = p.dist;
                return;
            }
            vis[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || rooms[nx][ny] == -1) continue;
                if (!vis[nx][ny]) {
                    vis[nx][ny] = true;
                    queue.offer(new Node(nx, ny, p.dist + 1));
                }
            }
        }
        // 无法到达
        rooms[row][col] = INF;
    }

    class Node {
        int x, y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    /* ************************多源BFS***********************************  */
    public void wallsAndGates2(int[][] rooms) {
        m = rooms.length;
        n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        /** 多源BFS 将所有门加入队列 以门为起点bfs */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) { // 门
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0], y = p[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || rooms[nx][ny] != INF) {
                    continue;
                }
                rooms[nx][ny] = rooms[x][y] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }
    }

    public static void main(String[] args) {
        int[][] rooms = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };
        new LC_286().wallsAndGates(rooms);
    }
}
