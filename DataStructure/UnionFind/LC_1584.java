package DataStructure.UnionFind;

import java.util.Arrays;
import java.util.Comparator;

public class LC_1584 {

    /*
        1584. 连接所有点的最小费用
     */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // n个点的连接方案 = n * n / 2
        int[][] graph = new int[n * n / 2][3];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dis = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                graph[index][0] = i;
                graph[index][1] = j;
                graph[index][2] = dis;
                index++;
            }
        }
        Arrays.sort(graph, (Comparator.comparingInt(o -> o[2])));
        UnionFind u = new UnionFind(points.length);
        int res = 0;
        for (int[] g : graph) {
            int a = g[0], b = g[1], cost = g[2];
            if (u.isConnected(a, b)) continue;
            u.union(a, b);
            res += cost;
        }
        return res;
    }

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

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];  // 路径压缩
                x = parent[x];
            }
            return x;
        }

        public void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot == bRoot) return;
            parent[aRoot] = bRoot;
            count--;
        }

        public boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(new LC_1584().minCostConnectPoints(points));
    }
}
