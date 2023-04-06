package Competition.biweekly.bw101;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T4 {

    List<Integer>[] g;
    int[] dis;
    public int findShortestCycle(int n, int[][] edges) {
        g = new ArrayList[n];
        dis = new int[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        int ans = 0x3f3f3f;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, bfs(i));
        }
        return ans;
    }

    int bfs(int start) {
        Arrays.fill(dis, -1);
        dis[start] = 0;
        var q = new LinkedList<int[]>();
        q.offer(new int[]{start, -1});
        while (q.size() > 0) {
            var p = q.poll();
            int x = p[0], fa = p[1];
            for (int y : g[x]) {
                if (dis[y] < 0) {
                    dis[y] = dis[x] + 1;
                    q.offer(new int[]{y, x});
                } else if (y != fa) {
                    return dis[x] + dis[y] + 1;
                }
            }
        }
        return 0x3f3f3f;
    }





    public static void main(String[] args) {

        int n = 8;
        int[][] e = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {0, 7}, {0, 6}, {5, 7}, {5, 6}};
        System.out.println(new T4().findShortestCycle(n, e));
    }
}
