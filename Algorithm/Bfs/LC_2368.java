package Algorithm.Bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC_2368 {

    /*
        2368. 受限条件下可到达节点的数目
     */
    boolean[] vis;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        vis = new boolean[n];
        for (int x : restricted) vis[x] = true;
        LinkedList<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] e : edges) {
            int from = e[0], to = e[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int p = queue.poll();
            cnt += 1;
            vis[p] = true;
            for (int next : graph[p]) {
                if (!vis[next]) {
                    queue.offer(next);
                }
            }
        }
        return cnt;
    }


    public static void main(String[] args) {

    }
}
