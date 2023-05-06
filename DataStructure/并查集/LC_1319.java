package DataStructure.并查集;

public class LC_1319 {

    /*
        1319. 连通网络的操作次数
     */
    public int makeConnected(int n, int[][] connections) {
        UnionFind u = new UnionFind(n);
        for (int[] c : connections) {
            int a = c[0], b = c[1];
            if (!u.isConnected(a, b)) {
                u.union(a, b);
            }
        }
        return u.getCount() - 1;
    }

    class UnionFind {
        int n;
        int count;
        int[] parent;

        public UnionFind(int n) {
            this.n = n;
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while(parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot == bRoot) return;
            parent[bRoot] = aRoot;
            count--;
        }

        boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {

    }
}
