package DataStructure.Graph;

import java.util.LinkedList;

public class LC_1466 {

    /*
        1466. 重新规划路线
     */
    private boolean[] vis;

    public int minReorder(int n, int[][] connections) {
        // 看作无向图
        // 每次遍历到下一个节点,判断这条边的方向是否正确
        vis = new boolean[n + 1];
        LinkedList<int[]>[] g = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }
        for (var con : connections) {
            int from = con[0], to = con[1];
            g[from].add(new int[]{to, 1}); // 正向
            g[to].add(new int[]{from, 0}); // 反向
        }
        int res = 0;
        var q = new LinkedList<Integer>();
        q.offer(0);
        vis[0] = true;
        // 从0开始bfs 将正向边的改为反向
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int[] next : g[u]) {
                if (!vis[next[0]]) {
                    if (next[1] == 1) res++;
                    vis[next[0]] = true;
                    q.offer(next[0]);
                }
            }
        }
        return res;
    }

    private int res;
//    private boolean[] vis;
    private LinkedList<int[]>[] g;


    public int minReorder2(int n, int[][] connections) {
        // 看作无向图
        // 每次遍历到下一个节点,判断这条边的方向是否正确
        // 从0开始dfs 将正向边的改为反向
        // 0 -> 1 需要改为 1 -> 0
        vis = new boolean[n + 1];
        g = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }
        for (var con : connections) {
            int from = con[0], to = con[1];
            g[from].add(new int[]{to, 1}); // 正向
            g[to].add(new int[]{from, 0}); // 反向
        }
        vis[0] = true;
        dfs(0);
        return res;
    }

    private void dfs(int cur) {
        for (var next : g[cur]) {
            if (!vis[next[0]]) {
                vis[next[0]] = true;
                if (next[1] == 1) res++;
                dfs(next[0]);
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] con = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(new LC_1466().minReorder(n, con));
    }
}
