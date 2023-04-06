package DataStructure.UnionFind;

public class LC_684 {

    /*
        684. 冗余连接
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind u = new UnionFind(n);
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            if (u.isConnected(a, b)) {
                return new int[]{a, b};
            } else {
                u.union(a, b);
            }
        }
        return new int[]{-1, -1};
    }

    class UnionFind {
        int n;
        int[] parent;

        public UnionFind(int n) {
            this.n = n;
            this.parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            while (x != parent[x]) {
                x = parent[parent[x]];
            }
            return x;
        }

        void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot == bRoot) return;
            parent[bRoot] = aRoot;
        }

        boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }
    }


    public static void main(String[] args) {

    }
}
