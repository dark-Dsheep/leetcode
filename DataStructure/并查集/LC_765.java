package DataStructure.并查集;

public class LC_765 {

    /*
        765. 情侣牵手
     */
    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int n = len / 2; // 情侣对数
        UnionFind u = new UnionFind(n);
        for (int i = 0; i < len; i += 2) {
            // 两个相邻的情侣进行合并操作无效，/2下取整
            u.union(row[i] / 2, row[i + 1] / 2);
        }
        return n - u.getCount();
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
            while (x != parent[x]) {
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

        public boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }

        public int getCount() {
            return count;
        }
    }
}
