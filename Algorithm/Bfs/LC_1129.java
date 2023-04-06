package Algorithm.Bfs;

import java.util.Arrays;
import java.util.LinkedList;

public class LC_1129 {

    /*
        1129. 颜色交替的最短路径
     */
    private LinkedList<Integer>[][] table;
    private boolean[][] vis;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        var res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;

        table = new LinkedList[2][n];
        vis = new boolean[2][n];
        // 初始化邻接表
        // table[0] 为红边所在邻接表
        // table[1] 为蓝边所在邻接表
        for (var i = 0; i < n; i++) {
            table[0][i] = new LinkedList<>();
            table[1][i] = new LinkedList<>();
        }
        for (var r : redEdges) table[0][r[0]].add(r[1]);
        for (var b : blueEdges) table[1][b[0]].add(b[1]);
        // 队列保存 (到该点的边颜色, 该点的值)
        var queue = new LinkedList<int[]>();
        // 假设存在两边到节点0 是两种不同的颜色 需要进行多源BFS
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{1, 0});
        vis[0][0] = vis[1][0] = true;
        var step = 1;
        while (!queue.isEmpty()) {
            var size = queue.size();
            while (size-- > 0) {
                var p = queue.poll();
                var color = p[0];
                var val = p[1];
                var nextColor = color ^ 1;  // 改变颜色
                for (var next : table[nextColor][val]) {
                    if (!vis[nextColor][next]) {
                        res[next] = Math.min(res[next], step);
                        queue.offer(new int[]{nextColor, next});
                        vis[nextColor][next] = true;
                    }
                }
            }
            step++;
        }
        for (var i = 1; i < n; i++) {
            // 不存在路径的节点标记为-1
            if (res[i] == Integer.MAX_VALUE) {
                res[i] = -1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        var n = 3;
        var redE = new int[][]{{0, 1}, {1, 2}};
        var blueE = new int[][]{};
        System.out.println(Arrays.toString(new LC_1129().shortestAlternatingPaths(n, redE, blueE)));
    }
}
