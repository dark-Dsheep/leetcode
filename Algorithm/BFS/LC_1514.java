package Algorithm.BFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LC_1514 {

    private HashSet<String> vis = new HashSet<>();         // 记录边是否重复访问
    private HashMap<String, Double> map = new HashMap<>(); // 保存边权

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        LinkedList<Integer>[] table = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            table[i] = new LinkedList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0], to = edges[i][1];
            table[from].add(to);
            table[to].add(from);
            var k1 = from + "_" + to;
            var k2 = to + "_" + from;
            map.put(k1, succProb[i]);
            map.put(k2, succProb[i]);
        }
        // 优先队列按 权值 从大到小存储节点
        var pq = new PriorityQueue<double[]>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[]{start, 1});
        vis.add("0_0");
        while (!pq.isEmpty()) {
            var p = pq.poll();
            int u = (int) p[0];
            double w = p[1];
            if (u == end) return w;
            for (var next : table[u]) {
                var key = u + "_" + next;
                if (!vis.contains(key)) {
                    vis.add(key);
                    var nw = map.get(key);
                    pq.offer(new double[]{next, nw * w});
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.3};
        int start = 0;
        int end = 2;
        System.out.println(new LC_1514().maxProbability(n, edges, succProb, start, end));
    }
}
