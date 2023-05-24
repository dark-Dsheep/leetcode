package Algorithm.BFS;

import java.util.*;

public class LC_2146 {

    /*
    2146. 价格范围内最高排名的 K 样物品
     */

    boolean[][] vis;
    int m, n = 0;
    int sx, sy = 0;
    int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        m = grid.length;
        n = grid[0].length;
        sx = start[0];
        sy = start[1];
        vis = new boolean[m][n];
        Queue<Node> queue = new LinkedList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.step != o2.step) return o1.step - o2.step;
            if (o1.price != o2.price) return o1.price - o2.price;
            if (o1.x != o2.x) return o1.x - o2.x;
            return o1.y - o2.y;
        });
        vis[sx][sy] = true;
        Node root =new Node(sx, sy, 0, grid[sx][sy]);
        // 特判起点是否在范围内
        if (grid[sx][sy] >= pricing[0] && grid[sx][sy] <= pricing[1]) {
            pq.offer(root);
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node p = queue.poll();
            int x = p.x, y = p.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0) continue;
                if (!vis[nx][ny]) {
                    vis[nx][ny] = true;
                    int nextPic = grid[nx][ny];
                    Node next = new Node(nx, ny, p.step + 1, nextPic);
                    if (nextPic >= pricing[0] && nextPic <= pricing[1]) {
                        pq.offer(next);
                    }
                    queue.offer(next);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        while (k-- > 0 && !pq.isEmpty()) {
            Node node = pq.poll();
            res.add(List.of(node.x, node.y));
        }
        return res;
    }

    class Node {
        int x;
        int y;
        int step;
        int price;

        public Node(int x, int y, int step, int price) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.price = price;
        }
    }

    public static void main(String[] args) {


        int[][] grid = {{1, 1, 1}, {0, 0, 1}, {2, 3, 4}};
        int[] pricing = {2, 3};
        int[] start = {0, 0};
        int k = 3;
        System.out.println(new LC_2146().highestRankedKItems(grid, pricing, start, k));
    }
}
