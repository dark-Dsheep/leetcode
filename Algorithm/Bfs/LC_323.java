package Algorithm.Bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LC_323 {

    /*
        323. 无向图中连通分量的数目
     */

    public int countComponents(int n, int[][] edges) {
        UnionFind u = new UnionFind(n);
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            u.union(a, b);
        }
        return u.getCount();
    }

    /*
        并查集写法
     */
    class UnionFind {
        int count;
        int[] parent;

        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot == bRoot) return;
            parent[bRoot] = aRoot;
            count--;
        }

        int getCount() {
            return count;
        }
    }


    /*
        BFS写法
     */
    boolean[] vis = new boolean[2010];

    public int countComponents2(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            graph.get(u).add(v); // 无向图边 (u,v)
            graph.get(v).add(u); // 无向图边 (v,u)
        }
        int count = 0;
        for(int u = 0; u < n; u++){
            if(!vis[u]) {
                count++;
                bfs(u, graph);
            }
        }
        return count;
    }
    private void bfs(int u, List<List<Integer>> graph){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(u);
        vis[u] = true;
        while(!q.isEmpty()){
            int v = q.remove();
            for(int w : graph.get(v)) {
                if(!vis[w]) {
                    q.add(w);
                    vis[w] = true;
                }
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new LC_323().countComponents2(2, new int[][]{{1, 0}}));
    }
}
