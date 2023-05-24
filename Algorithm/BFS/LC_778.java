package Algorithm.BFS;

import java.util.PriorityQueue;

public class LC_778 {


    boolean[][] vis = new boolean[60][60];
    int m, n = 0;
    int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /*
    778. 水位上升的泳池中游泳
     */
    public int swimInWater(int[][] grid) {
        // bfs优先拓展四个方向高度最低的节点
        m = grid.length;
        n = grid[0].length;
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.h - o2.h);
        queue.offer(new Node(0, 0, 0, 0));
        vis[0][0] = true;
        int res = grid[0][0];
        while (!queue.isEmpty()) {
            Node p = queue.poll();
            int x = p.x, y = p.y;
            // res是路径中最高的平台，我们需要等到水池水位到达maxH
            res = Math.max(res, p.h);
            if (x == m - 1 && y == n - 1) {
                return res;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (!vis[nx][ny]) {
                    vis[nx][ny] = true;
                    queue.offer(new Node(nx, ny, grid[nx][ny], p.step + 1));
                }
            }
        }
        return -1;
    }

    class Node {
        int x;
        int y;
        int h;
        int step;

        public Node(int x, int y, int h, int step) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.step = step;
        }
    }

    public static void main(String[] args) {

    }
}
