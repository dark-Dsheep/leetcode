package Competition.biweekly.bw102;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class T4 {


    class Graph {

        List<Integer>[] g;
        int[][] w;
        int[] dist;

        public Graph(int n, int[][] edges) {
            w = new int[110][110];
            dist = new int[110];
            g = new ArrayList[n+110];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (var e : edges) {
                int x = e[0], y = e[1];
                g[x].add(y);
                w[x][y] = e[2];
            }
        }

        public void addEdge(int[] edge) {
            int x = edge[0], y = edge[1];
            g[x].add(y);
            w[x][y] = edge[2];
        }

        public int shortestPath(int from, int to) {
            Arrays.fill(dist, 0x3f3f3f);
            var pq = new PriorityQueue<Integer>((a, b) -> dist[a] - dist[b]);
            pq.offer(from);
            dist[from] = 0;
            while (pq.size() > 0) {
                int p = pq.poll();
                for (int nx : g[p]) {
                    if (dist[nx] > dist[p] + w[p][nx]) {
                        dist[nx] = dist[p] + w[p][nx];
                        pq.offer(nx);
                    }
                }
            }
            return dist[to] == 0x3f3f3f ? -1 : dist[to];
        }
    }

    public static void main(String[] args) {

    }
}
