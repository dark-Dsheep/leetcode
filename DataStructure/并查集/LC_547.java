package DataStructure.并查集;

public class LC_547 {

    /*
        547. 省份数量
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind u = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    u.union(i, j);
                }
            }
        }
        return u.getCount();
    }

    class UnionFind {
        int n, count;
        int[] parent;

        public UnionFind(int n) {
            this.n = n;
            this.count = n;
            this.parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                x = parent[parent[x]];
            }
            return x;
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) return;
            parent[yRoot] = xRoot;
            count--;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {

    }
}
