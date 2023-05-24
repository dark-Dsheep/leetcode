package Algorithm.BFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LC_787 {

    /*
        787. K 站中转内最便宜的航班
     */

    // TODO

    private HashSet<String> vis = new HashSet<>();         // 记录边是否重复访问
    private HashMap<String, Integer> map = new HashMap<>(); // 保存边权

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        LinkedList<Integer>[] table = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            table[i] = new LinkedList<>();
        }
        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0], to = flights[i][1];
            table[from].add(to);
            var k1 = from + "_" + to;
            map.put(k1, flights[i][2]);
        }
        // 优先队列按 权值 从小到大存储节点
        var pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{src, 0});

        int res = Integer.MAX_VALUE;
        while (k > 0 && !pq.isEmpty()) {
            int size = pq.size();
            while (size-- > 0) {
                var p = pq.poll();
                int u = p[0], w = p[1];
                if (u == dst) return w;
                for (int next : table[u]) {
                    var key = u + "_" + next;
                    if (!vis.contains(key)) {
                        vis.add(key);
                        pq.offer(new int[]{next, w + map.get(key)});
                    }
                }
            }
            k--;
        }
        for (var con : pq) {
            for (int next : table[con[0]]) {
                if (next == dst) {
                    var key = con[0] + "_" + next;
                    res = Math.min(res, con[1] + map.get(key));
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};
        int n = 4, src = 0, dst = 3, k = 1;
        System.out.println(new LC_787().findCheapestPrice(n,edges, src, dst, k));
    }
}
