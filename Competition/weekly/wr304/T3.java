package Competition.weekly.wr304;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T3 {

    static final int INF = 0x3f3f3f;
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        // 把node1到所有点的距离求出来
        // 把node2到所有点的距离求出来
        int n = edges.length;
        int[] d1 = new int[n], d2 = new int[n];
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
            if (edges[i] != -1) g[i].add(edges[i]);
        }
        for (int i = 0; i < n; i++) { d1[i] = INF; d2[i] = INF; }
        bfs(g, node1, d1);
        bfs(g, node2, d2);
        int minDis = INF;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int d = Math.max(d1[i], d2[i]);
            if (d < minDis) {
                minDis = d;
                ans = i;
            }
        }
        return ans;
    }

    void bfs(List<Integer>[] g, int start, int[] dist) {
        boolean[] vis = new boolean[g.length];
        var q = new LinkedList<Integer>();
        dist[start] = 0;
        vis[start] = true;
        q.offer(start);
        while (q.size() > 0) {
            var u = q.poll();
            for (int v : g[u]) {
                if (!vis[v]) {
                    q.offer(v);
                    dist[v] = dist[u] + 1;
                    vis[v] = true;
                }
            }
        }
        dist[start] = 0;
    }

    public static void main(String[] args) {
        int[] e = {4, 4, 4, 5, 1, 2, 2};
        System.out.println(new T3().closestMeetingNode(e, 1, 1));
    }
}
