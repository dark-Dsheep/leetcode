package DataStructure.UnionFind;

import java.util.Arrays;
import java.util.Comparator;

public class LC_1135 {

    /*
        1135. 最低成本联通所有城市
     */
    public int minimumCost(int n, int[][] connections) {
        // 将费用从小到达排序
        Arrays.sort(connections, (Comparator.comparingInt(o -> o[2])));
        UnionFind u = new UnionFind(n);
        int res = 0;
        for (int[] con : connections) {
            int a = con[0], b = con[1];
            if (u.isConnected(a, b)) {  // 两点已经连接
                continue;
            }
            u.union(a, b);
            res += con[2];
            if (u.getCount() == 1) return res;
        }
        return -1;
    }

    class UnionFind {
        int count;
        int[] parent;

        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
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
        int n = 4;
        int[][] conections = {{1, 2, 3}, {3, 4, 4}};
        System.out.println(new LC_1135().minimumCost(n, conections));
    }
}
