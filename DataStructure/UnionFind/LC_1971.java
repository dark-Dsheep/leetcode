package DataStructure.UnionFind;

public class LC_1971 {

    /*
        1971. 寻找图中是否存在路径
     */
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // 判断 两个点是否属于同一连通块即可
        UnionFind u = new UnionFind(n);
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            u.union(a, b);
        }
        return u.find(source) == u.find(destination);
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

    }
}
