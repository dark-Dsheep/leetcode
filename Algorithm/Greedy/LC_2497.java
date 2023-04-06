package Algorithm.Greedy;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class LC_2497 {


    /*
        LC_2497.最大星图和
     */
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        var n = vals.length;
        // 无向图 最多包含k条边的最大和
        var table = new LinkedList[n];
        for (var i = 0; i < n; i++) {
            table[i] = new LinkedList<>();
        }
        for (var i = 0; i < edges.length; i++) {
            var from = edges[i][0];
            var to = edges[i][1];
            // 节点值 > 0的才记录
            if (vals[to] > 0) table[from].add(to);
            if (vals[from] > 0) table[to].add(from);
        }
        var res = Integer.MIN_VALUE;
        for (var i = 0; i < n; i++) {
            var sum = 0;
            LinkedList<Integer> node = table[i];
            var m = Math.min(k, node.size());
            // 对节点的值从大至小排序
            node.sort(((o1, o2) -> vals[o2] - vals[o1]));
            // 对节点临边取前k个
            for (var j = 0; j < m; j++) {
                sum += vals[node.get(j)];
            }
            res = Math.max(res, sum + vals[i]);
        }
        return res;
    }

    public int maxStarSum2(int[] vals, int[][] edges, int k) {
        var n = vals.length;
        PriorityQueue<Integer>[] pq = new PriorityQueue[n];
        for (var i = 0; i < n; i++) {
            // 大顶堆
            pq[i] = new PriorityQueue<>(((o1, o2) -> vals[o2] - vals[o1]));
        }
        for (int[] e : edges) {
            var from = e[0];
            var to = e[1];
            // 节点值大于0才记录
            if (vals[to] > 0) pq[from].offer(to);
            if (vals[from] > 0) pq[to].offer(from);
        }
        var res = Integer.MIN_VALUE;
        for (var i = 0; i < n; i++) {
            var sum = 0;
            PriorityQueue<Integer> q = pq[i];
            var m = Math.min(k, q.size());
            // 大顶堆取前k个
            for (int j = 0; j < m; j++) {
                sum += vals[q.poll()];
            }
            res = Math.max(res, sum + vals[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        var vals = new int[] {1, -8, 0};
        var edges = new int[][] {{0, 1}, {2, 1}};
        var k = 2;
        System.out.println(new LC_2497().maxStarSum2(vals, edges, k));
    }
}
