package Algorithm.Bfs;

import java.util.LinkedList;

public class LC_847 {

//    847. 访问所有节点的最短路径

    public int shortestPathLength(int[][] graph) {
        int n = graph.length, end = (1 << n) - 1;
        var vis = new boolean[n][1 << n];
        var q = new LinkedList<int[]>();
        for (int i = 0; i < n; i++) {
            q.offer(new int[]{i, (1 << i)});
        }
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                var p = q.poll();
                int u = p[0], state = p[1];
                if (state == end) return step;
                for (int v : graph[u]) {
                    int nstate = state | (1 << v);
                    if (!vis[v][nstate]) {
                        vis[v][nstate] = true;
                        q.offer(new int[]{v, nstate});
                    }
                }
            }
            step++;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[][] g = {{1, 2, 3}, {0}, {0}, {0}};
        System.out.println(new LC_847().shortestPathLength(g));
    }
}
